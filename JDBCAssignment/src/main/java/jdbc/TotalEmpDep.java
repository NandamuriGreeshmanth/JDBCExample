package jdbc;

import java.sql.*;
import java.util.Scanner;

public class TotalEmpDep {
    public static void displayemdep() {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Scanner sc=new Scanner(System.in);
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/indexes","root","Greeshmanth@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {

            String sql="select count(*) from employee where dept=?";
            ps =connection.prepareStatement(sql);
             System.out.println("enter the dept");
             String dept=sc.nextLine();
              ps.setString(1,dept);
            rs=ps.executeQuery();

            while(rs.next())
            {
                int totalemployees=rs.getInt(1);
                System.out.println("Total no of employees in "+dept +" "+ totalemployees);
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
