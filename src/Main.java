import com.example.model.CEO;
import com.example.model.Employee;
import com.example.model.Manager;
import com.example.service.StaffService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StaffService service = new StaffService();
        boolean check = true;

        do {
            System.out.println("1: Nhập thông tin công ty.\n" +
                    "2: Phân bổ Nhân viên vào Trưởng phòng.\n" +
                    "3: Thêm nhân sự.\n" +
                    "4: Xoá nhân sự.\n" +
                    "5: Xuất ra thông tin toàn bộ người trong công ty.\n" +
                    "6: Tính và xuất tổng lương cho toàn công ty.\n" +
                    "7: Tìm Nhân viên thường có lương cao nhất.\n" +
                    "8: Exit \n");
            Scanner sca = new Scanner(System.in);
            int choice = sca.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Company name?");
                    String name = sca.next();
                    System.out.println("Company tax number?");
                    String taxNumber = sca.next();
                    System.out.println("income?");
                    String income = sca.next();
                    service.createCompany(name, taxNumber, income);
                    break;
                case 2:
                    System.out.println("Manager ID?");
                    int managerIdCase2 = sca.nextInt();
                    System.out.println("Employee ID?");
                    int employeeId = sca.nextInt();
                    Employee employeeCase2 = service.arrangeEmployee(managerIdCase2, employeeId);
                    System.out.println(employeeCase2);
                    break;
                case 3:
                    System.out.println("What staff role you want to create?");
                    String role = sca.next();
                    System.out.println("Staff name?");
                    String staffName = sca.next();
                    System.out.println("Staff phone number?");
                    String phone = sca.next();
                    System.out.println("Staff working day?");
                    int workingDay = sca.nextInt();
                    if (role.equalsIgnoreCase("employee")) {
                        System.out.println("Manager id ?");
                        int managerId = sca.nextInt();
                        Employee employee = service.createEmployee(staffName, phone, workingDay, managerId);
                        System.out.println(employee.toString());
                    } else if (role.equalsIgnoreCase("manager")) {
                        Manager manager = service.createManager(staffName, phone, workingDay);
                        System.out.println(manager.toString());
                    } else if (role.equalsIgnoreCase("ceo")) {
                        System.out.println("share number?");
                        int share = sca.nextInt();
                        CEO ceo = service.createCEO(staffName, phone, workingDay, share);
                        System.out.println(ceo.toString());
                    } else {
                        System.out.println("There are no that role " + role);
                    }
                    break;
                case 4:
                    System.out.println("Staff id? ");
                    int id = sca.nextInt();
                    service.deleteStaff(id);
                    break;
                case 5:
                    service.getCompanyStaffInfo();
                    break;
                case 6:
                    service.calculateAllSalary();
                    break;
                case 7:
                    System.out.println(service.getHighestSalaryEmployee());
                    break;
                case 8:
                    System.out.println("Are you sure ? (Y or N)");
                    String exit = sca.next();
                    if (exit.equalsIgnoreCase("Y")) {
                        check = false;
                        System.out.println("Good Bye");
                    }
                    break;
                default:
                    System.out.println("ReChoice option. We just have 12 choice");
            }
        } while (check);
    }
}