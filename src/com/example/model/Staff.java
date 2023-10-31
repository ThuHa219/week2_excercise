package com.example.model;

import java.util.Objects;

public abstract class Staff {
    private int id;

    private String name;

    private String phoneNumber;

    private int workingDay;

    private int salaryPerDay;

    public Staff(int id, String name, String phoneNumber, int workingDay) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.workingDay = workingDay;
    }

    public Staff() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(int workingDay) {
        this.workingDay = workingDay;
    }

    public int getSalaryPerDay() {
        return salaryPerDay;
    }

    public void setSalaryPerDay(int salaryPerDay) {
        this.salaryPerDay = salaryPerDay;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", workingDay=" + workingDay +
                ", salaryPerDay=" + salaryPerDay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (id != staff.id) return false;
        if (workingDay != staff.workingDay) return false;
        if (salaryPerDay != staff.salaryPerDay) return false;
        if (!name.equals(staff.name)) return false;
        return Objects.equals(phoneNumber, staff.phoneNumber);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + workingDay;
        result = 31 * result + salaryPerDay;
        return result;
    }

    public abstract int calculateSalary();
}
