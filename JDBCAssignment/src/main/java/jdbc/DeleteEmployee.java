package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteEmployee {
    public static void DeleteEmpid() {
        Connection connection = null;
        PreparedStatement ps = null;
        Scanner sc = new Scanner(System.in);
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/indexes", "root", "Greeshmanth@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            String sql="delete from employee where id=?";
            ps = connection.prepareStatement(sql);
            System.out.println("Enter the emp id to be deleted");
            int empid=sc.nextInt();
            ps.setInt(1,empid);
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
