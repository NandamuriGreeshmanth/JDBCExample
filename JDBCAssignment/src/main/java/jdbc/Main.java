package jdbc;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n--- Employee Management Menu ---");
                System.out.println("1 Display all employees");
                System.out.println("2 Display employee by ID");
                System.out.println("3 Insert employee (CallableStatement)");
                System.out.println("4 Update designation by emp ID");
                System.out.println("5 Delete employee by ID");
                System.out.println("6 Display total number of employees");
                System.out.println("7 Display total number of employees in a department");
                System.out.println("0 Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        EmployeeJDBC.display();
                        break;
                    case 2:
                        Employeeid.employeedetails();
                        break;
                    case 3:
                        insertemployee.insertemp();
                        break;
                    case 4:
                        UpdateEmployee.updateemp();
                        break;
                    case 5:
                        DeleteEmployee.DeleteEmpid();
                        break;
                    case 6:
                        DisplaytotalEmp.DisplayTEmp();
                        break;
                    case 7:
                        TotalEmpDep.displayemdep();
                        break;
                    case 0:
                        System.out.println("Exiting program");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again");
                }

            } while (choice != 0);

            sc.close();
        }
    }

