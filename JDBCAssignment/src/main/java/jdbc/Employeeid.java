package jdbc;

import java.sql.*;
import java.util.Scanner;

public class Employeeid {
    public static void employeedetails() {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        Scanner sc=new Scanner(System.in);
        try {
             connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/indexes","root","Greeshmanth@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            String sql="select * from employee where id=?";
             ps = connection.prepareStatement(sql);
             System.out.println("enter the empid");
             int empid=sc.nextInt();
             ps.setInt(1,empid);
             rs=ps.executeQuery();

             while(rs.next())
             {
                 System.out.println(rs.getInt("id")+" - "+rs.getString("name")+" - "+rs.getString(3));
             }

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
