package com.example.model;

import java.util.Objects;

public class Company {
    private String name;

    private String taxNumber;

    private String income;

    public Company(String name, String taxNumber, String income) {
        this.name = name;
        this.taxNumber = taxNumber;
        this.income = income;
    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", income='" + income + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (!Objects.equals(name, company.name)) return false;
        if (!Objects.equals(taxNumber, company.taxNumber)) return false;
        return Objects.equals(income, company.income);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (taxNumber != null ? taxNumber.hashCode() : 0);
        result = 31 * result + (income != null ? income.hashCode() : 0);
        return result;
    }
}
