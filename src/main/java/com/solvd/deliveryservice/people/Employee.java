package com.solvd.deliveryservice.people;

public abstract class Employee extends Person {
    private final static int MASK = 10;
    private static int idCounter = 1;
    private int id;

    public Employee() {}

    public Employee(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.id = idCounter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.getFirstName() + ", Id: " + id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (hashCode() != obj.hashCode()) return false;
        Employee employee = (Employee) obj;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return MASK + super.hashCode() + id;
    }

    public abstract void work();
}