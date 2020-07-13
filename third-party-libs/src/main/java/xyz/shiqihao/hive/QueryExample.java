package xyz.shiqihao.hive;

import java.sql.*;

public class QueryExample {
    private final static String DRIVER_NAME = "org.apache.hive.jdbc.HiveDriver";

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection("jdbc:hive2://shiqihao.xyz:10000/default");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select * from foobar");
        while (result.next()) {
            System.out.println(result.getString(1) + " : " + result.getString(2));
        }
    }
}
