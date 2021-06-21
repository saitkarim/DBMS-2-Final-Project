package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "";
        String databaseUser = "pdbadmin";
        String databasePassword = "Liverpool2002";
        String url = "jdbc:oracle:thin:@localhost:1521/ORCLPDB";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }
}
