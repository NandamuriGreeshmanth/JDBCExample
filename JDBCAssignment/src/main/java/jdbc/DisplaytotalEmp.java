package jdbc;

import java.sql.*;

public class DisplaytotalEmp {
    public static void DisplayTEmp() {
        Connection connection=null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/indexes","root","Greeshmanth@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {

            String sql="select count(*) from employee";
            statement =connection.createStatement();

            rs=statement.executeQuery(sql);

            while(rs.next())
            {
                int totalemployees=rs.getInt(1);
                System.out.println("Total no of employees "+totalemployees);
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
