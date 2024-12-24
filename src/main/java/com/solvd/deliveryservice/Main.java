package com.solvd.deliveryservice;

import com.solvd.deliveryservice.exceptions.CustomerNotFoundException;
import com.solvd.deliveryservice.exceptions.PackageNotFoundException;
import com.solvd.deliveryservice.packages.Package;
import com.solvd.deliveryservice.people.customers.Customer;
import com.solvd.deliveryservice.people.employees.Collector;
import com.solvd.deliveryservice.people.employees.Courier;
import com.solvd.deliveryservice.request.DeliveryPreference;
import com.solvd.deliveryservice.request.DeliveryRequest;
import com.solvd.deliveryservice.transport.*;
import com.solvd.deliveryservice.utils.LinkedList;
import com.solvd.deliveryservice.utils.TextParser;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    private final static Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Hello world! - said the DeliveryService");
        Office o1 = new Office("Poststreet 25");
        Server s = new Server();
        s.importCustomers();
        Transport t1 = new Car();
        Transport t2 = new Plane();
        Transport t3 = new Scooter();
        Courier cr1 = new Courier("Rigel", "Postman", 25, 859309549, t2);
        Collector cl1 = new Collector("Bella", "Collectorina", 30);
        o1.addEmployee(cr1);
        o1.addEmployee(cl1);
        logger.info(o1.getEmployees());
        Customer c1 = new Customer("Big", "Customer", 27, "Customstreet 27", DeliveryPreference.COURIER);
        c1.order();
        com.solvd.deliveryservice.packages.Package.displayData("cm, kg");
        com.solvd.deliveryservice.packages.Package p1 = new Package(new int[]{10, 10, 10}, 10);
        DeliveryRequest r1 = new DeliveryRequest(c1, p1);
        try {
            s.addRequest(r1);
        } catch (CustomerNotFoundException | PackageNotFoundException e) {
            logger.error(e.getMessage());
        }
        cl1.work();
        cl1.storeRequestPackage(o1.getStorage(), s.getRequest(r1));
        cl1.giveCourier(o1.getStorage(), s.getRequest(r1), cr1);
        logger.info(r1.getId());
        logger.info(r1.getCustomer().getPreference());
        logger.info(r1.getPack().getSizeX());
        logger.info(cr1.getTransport().getClass());
        cr1.work();
        cr1.getTransport().travel();
        LinkedList<String> list = new LinkedList<>();
        list.add("Bravo");
        list.add("Delta");
        list.add("Charlie");
        list.add("List");
        list.add("Delta");
        list.print();
        TextParser.parse();
        logger.info(s.getAddressNumber(c1.getAddress(), str -> Integer.parseInt(StringUtils.getDigits(str))));
        logger.info(s.doLambdaOperation(c1.getAddress(), element -> element + element));
        try {
            Class<?> cls = Class.forName("com.solvd.deliveryservice.people.employees.Courier");
            for (Method m : cls.getDeclaredMethods()) {
                if (m.getName().equals("work"))
                    m.invoke(new com.solvd.deliveryservice.people.employees.Courier());
            }
        } catch (ClassNotFoundException e) {
            logger.error("Class not found");
        } catch (InvocationTargetException | IllegalAccessException e) {
            logger.error("Invocation failed");
        }
    }
}