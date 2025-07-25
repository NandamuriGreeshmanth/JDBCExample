package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEmployee {
    public static void updateemp() {
        Connection connection=null;
        PreparedStatement ps=null;
        Scanner sc=new Scanner(System.in);

        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/indexes","root","Greeshmanth@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            String sql="update employee set designation=? where id=?";
            System.out.println("Enter the emp id to be updated");
            int empid=sc.nextInt();
            sc.nextLine();
            System.out.println("enter new designation");
            String newdesig=sc.nextLine();
            ps = connection.prepareStatement(sql);
            ps.setString(1,newdesig);
            ps.setInt(2,empid);
            ps.executeUpdate();
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
