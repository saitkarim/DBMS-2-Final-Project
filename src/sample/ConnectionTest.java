package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ConnectionTest {
    public Connection databaseLink;

    public Connection getConnection(){


        return databaseLink;
    }

    public static void main(String[] args) {
        String databaseName = "";
        String databaseUser = "pdbadmin";
        String databasePassword = "190103371";
        String url = "jdbc:oracle:thin:@localhost:1521/ORCLPDB";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

            Connection connection = databaseLink;
            String query = "SELECT * from employees";
            ResultSet rs = connection.createStatement().executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getInt(1) + rs.getString(2));
            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
}
