package com.example.model;

public class Manager extends Staff {

    private int employeeNumber;

    public Manager(int id, String name, String phoneNumber, int workingDay) {
        super(id, name, phoneNumber, workingDay);
        this.setSalaryPerDay(200);
    }

    public Manager() {
        this.setSalaryPerDay(200);
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public String toString() {
        return "Manager{" + super.toString() +
                ", employeeNumber=" + employeeNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Manager manager = (Manager) o;

        return employeeNumber == manager.employeeNumber;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + employeeNumber;
        return result;
    }

    @Override
    public int calculateSalary() {
        return this.getSalaryPerDay() * this.getWorkingDay() + 100 * this.getEmployeeNumber();
    }
}
