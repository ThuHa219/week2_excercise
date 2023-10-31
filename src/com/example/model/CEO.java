package com.example.model;

import com.example.exception.OutOfSharingException;

public class CEO extends Staff {

    private int share;

    public CEO(int id, String name, String phoneNumber, int workingDay, int share) {
        super(id, name, phoneNumber, workingDay);
        this.setSalaryPerDay(300);
        if(share > 100 || share < 0) {
            throw new OutOfSharingException("Out of sharing range from 0 to 100");
        }
        this.share = share;
    }

    public CEO() {
        this.setSalaryPerDay(300);
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        if(share > 100 || share < 0) {
            throw new OutOfSharingException("Out of sharing range from 0 to 100");
        }
        this.share = share;
    }

    @Override
    public String toString() {
        return "CEO{" + super.toString() +
                ", share=" + share +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CEO ceo = (CEO) o;

        return share == ceo.share;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + share;
        return result;
    }

    @Override
    public int calculateSalary() {
        return this.getSalaryPerDay() * this.getWorkingDay();
    }
}
