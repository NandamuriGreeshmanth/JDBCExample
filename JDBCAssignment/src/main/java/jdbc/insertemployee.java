package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class insertemployee {
    public static void insertemp() {
        Connection connection=null;
        CallableStatement cs= null;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter name");
        String name=sc.nextLine();

        System.out.println("Enter Department");
        String dept=sc.nextLine();

        System.out.println("Enter designaton");
        String desig=sc.nextLine();

        System.out.println("Enter Email");
        String email=sc.nextLine();

        System.out.println("Enter Salary");
        Double salary=sc.nextDouble();

        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/indexes","root","Greeshmanth@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            cs = connection.prepareCall("{call insert_employee(?,?,?,?,?)}");
            cs.setString(1,name);
            cs.setString(2,dept);
            cs.setString(3,desig);
            cs.setString(4,email);
            cs.setDouble(5,salary);

            int rowsAffected =cs.executeUpdate();
            System.out.println(rowsAffected+"rows inserted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
