package com.solvd.deliveryservice;

import com.solvd.deliveryservice.people.Employee;
import com.solvd.deliveryservice.storage.OfficeStash;
import com.solvd.deliveryservice.storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class Office implements IOffice {
    private final static int MASK = 10;
    private final static int MAX_CAPACITY = 100;
    private String address;
    private Storage storage;
    private List<Employee> employees;

    public Office() {}

    public Office(String address) {
        this.address = address;
        this.storage = new OfficeStash(MAX_CAPACITY, address);
        this.employees = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Office address: " + address;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (hashCode() != obj.hashCode()) return false;
        Office office = (Office) obj;
        return address.equals(office.address);
    }

    @Override
    public int hashCode() {
        return MASK + super.hashCode() + address.hashCode();
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}