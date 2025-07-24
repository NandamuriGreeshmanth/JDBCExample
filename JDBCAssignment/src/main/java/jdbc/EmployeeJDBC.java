package jdbc;
import java.sql.*;

public class EmployeeJDBC {
    public static void display() {
        Connection connection=null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/indexes","root","Greeshmanth@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sql = "select * from employee";
        try {
            statement =connection.createStatement();

            rs=statement.executeQuery(sql);

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
