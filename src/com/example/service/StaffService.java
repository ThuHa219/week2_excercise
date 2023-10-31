package com.example.service;

import com.example.model.*;

import java.util.ArrayList;
import java.util.List;

public class StaffService {

    private List<Staff> staffs= new ArrayList<>();

    private int id = 0;

    public Company createCompany(String name, String taxNumber, String income) {
        return new Company(name, taxNumber, income);
    }

    public Employee arrangeEmployee(int managerId, int employeeId) {
        int managerIndex = getById(managerId);
        int employeeIndex = getById(employeeId);
        if(managerIndex != -1 && employeeIndex != -1) {
            Staff manager = this.staffs.get(managerIndex);
            Staff employee = this.staffs.get(employeeIndex);
            if(manager instanceof Manager && employee instanceof Employee) {
                ((Employee) employee).setManager((Manager) manager);
                return (Employee) employee;
            }
        }
        return null;
    }

    public int getById(int id) {
        for(int i = 0; i < this.staffs.size(); i++) {
            if(this.staffs.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Employee createEmployee(String name, String phoneNumber, int workingDay, int managerId) {
        Manager manager = null;
        int index = getById(managerId);
        if(index != -1 ) {
            Staff staff = this.staffs.get(index);
            if (staff instanceof Manager) {
                manager = (Manager) staff;
            }
        }
        Employee employee = new Employee(id++, name, phoneNumber, workingDay, manager);
        this.staffs.add(employee);
        return employee;
    }

    public Manager createManager(String name, String phoneNumber, int workingDay) {
        Manager manager = new Manager(id++, name, phoneNumber, workingDay);
        this.staffs.add(manager);
        return manager;
    }

    public CEO createCEO(String name, String phoneNumber, int workingDay, int share) {
        CEO ceo = new CEO(id++, name, phoneNumber, workingDay, share);
        this.staffs.add(ceo);
        return ceo;
    }

    public void deleteStaff(int staffId) {
        int index = getById(staffId);
        if (index != -1) {
            Staff staff = this.staffs.get(index);
            this.staffs.remove(index);
            if (staff instanceof Manager) {
                for (Staff s : this.staffs) {
                    if (s instanceof Employee) {
                        if (((Employee) s).getManager().getId() == staff.getId()) {
                            ((Employee) s).setManager(null);
                        }
                    }
                }
            } else if (staff instanceof Employee) {
                for (Staff s : this.staffs) {
                    if (s instanceof Manager) {
                        if (((Employee) staff).getManager().getId() == s.getId()) {
                            ((Manager) s).setEmployeeNumber(((Manager) s).getEmployeeNumber() - 1);
                        }
                    }
                }
            }
        }
    }

    public void getCompanyStaffInfo() {
        for(Staff s : this.staffs) {
            System.out.println(s.toString());
        }
    }

    public void calculateAllSalary() {
        for(Staff s : this.staffs) {
            System.out.println(s.toString() + " Salary: " + s.calculateSalary());
        }
    }

    public Employee getHighestSalaryEmployee() {
        int highestSalary = 0;
        Employee highestSalaryEmployee = null;
        for(Staff s : this.staffs) {
            if(s instanceof Employee) {
                if(s.calculateSalary() > highestSalary) {
                    highestSalary = s.calculateSalary();
                    highestSalaryEmployee = (Employee) s;
                }
            }
        }
        return highestSalaryEmployee;
    }
}
