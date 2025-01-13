package com.solvd.deliveryservice;

import com.solvd.deliveryservice.exceptions.CustomerNotFoundException;
import com.solvd.deliveryservice.exceptions.PackageNotFoundException;
import com.solvd.deliveryservice.people.customers.Customer;
import com.solvd.deliveryservice.request.DeliveryPreference;
import com.solvd.deliveryservice.request.DeliveryRequest;
import com.solvd.deliveryservice.utils.AddressToIntegerFunction;
import com.solvd.deliveryservice.utils.UniversalFunction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
    private final static Logger logger = LogManager.getLogger(Server.class.getName());
    private List<DeliveryRequest> requests;
    private List<Customer> customers;

    public Server() {
        this.requests = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public List<DeliveryRequest> getRequests() {
        return requests;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setRequests(List<DeliveryRequest> requests) {
        this.requests = requests;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public DeliveryRequest getRequest(DeliveryRequest request) {
        return this.requests.get(this.requests.indexOf(request));
    }

    public Customer getCustomer(Customer customer) {
        return this.customers.get(this.customers.indexOf(customer));
    }

    public void addRequest(DeliveryRequest request) throws CustomerNotFoundException, PackageNotFoundException {
        if (request.getCustomer() == null)
            throw new CustomerNotFoundException(null);
        if (request.getPack() == null)
            throw new PackageNotFoundException(null);
        this.requests.add(request);
    }

    public void addCustomer(Customer customer) throws CustomerNotFoundException {
        if (customer == null)
            throw new CustomerNotFoundException(null);
        this.customers.add(customer);
    }

    public void removeRequest(DeliveryRequest request) {
        try {
            this.requests.remove(request);
        } catch (IllegalStateException e) {
            logger.info("Remove request from empty list is illegal{}", e.getMessage());
        }
    }

    public void removeCustomer(Customer customer) {
        try {
            this.customers.remove(customer);
        } catch (IllegalStateException e) {
            logger.info("Remove customer from empty list is illegal{}", e.getMessage());
        }
    }

    public void importCustomers() {
        try (Scanner scanner = new Scanner(new File("customers.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.trim().split("\\s+");
                addCustomer(new Customer(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3] + " " + parts[4], DeliveryPreference.valueOf(parts[5])));
            }
        } catch (FileNotFoundException fnfe) {
            logger.error(fnfe.getMessage());
        } catch (CustomerNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> filterCustomers(int age) {
        return this.customers.stream().filter(c -> c.getAge() == age).toList();
    }

    public static <T> void displayData(T element) {
        logger.info(element);
    }

    public int getAddressNumber(String str, AddressToIntegerFunction function) {
       return function.convertToInteger(str);
    }

    public <T> T doLambdaOperation(T element, UniversalFunction<T> function) {
        return function.doOperation(element);
    }

}
