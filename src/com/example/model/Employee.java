package com.example.model;

import java.util.Objects;

public class Employee extends Staff {

    private Manager manager;

    public Employee(int id, String name, String phoneNumber, int workingDay, Manager manager) {
        super(id, name, phoneNumber, workingDay);
        this.setSalaryPerDay(100);
        this.manager = manager;
        if(manager != null) {
            this.manager.setEmployeeNumber(this.manager.getEmployeeNumber() + 1);
        }
    }

    public Employee() {
        this.setSalaryPerDay(100);
    }

    public Manager getManager() {
        return manager;
    }

    @Override
    public String toString() {
        if(manager == null) {
            return "Employee{" + super.toString() +
                    ", manager=" + null +
                    '}';
        }
        return "Employee{" + super.toString() +
                ", manager=" + manager.toString() +
                '}';
    }

    public void setManager(Manager manager) {
        this.manager = manager;
        if(manager != null) {
            this.manager.setEmployeeNumber(this.manager.getEmployeeNumber() + 1);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;

        return Objects.equals(manager, employee.manager);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        return result;
    }

    @Override
    public int calculateSalary() {
        return this.getSalaryPerDay() * this.getWorkingDay();
    }
}
