package xyz.shiqihao.misc.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC的关键组件:
 * 1. Connection(获取Connection的2种方式)
 * 2. Statement/PreparedStatement
 * 3. ResultSet
 * JDBC4以后不用手动用Class.forName("org.postgresql.Driver")的方式注册
 */
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        try {
            Connection c = m.getConnection();
            DatabaseMetaData metaData = c.getMetaData();
            System.out.println(metaData.getJDBCMajorVersion() + "." + metaData.getJDBCMinorVersion());

            PreparedStatement createUser = c.prepareStatement("insert into public.user(name," +
                    "age, city, password) values(?, ?, ?, ?)");
            createUser.setString(1, "test2");
            createUser.setInt(2, 2);
            createUser.setString(3, "Cixi");
            createUser.setString(4, "123456");
            //createUser.execute();

            Statement getUsers = c.createStatement();
            ResultSet rs1 = getUsers.executeQuery("select * from public.user;");
            List<User> result = new ArrayList<>();
            while (rs1.next()) {
                int id = rs1.getInt(1);
                String name = rs1.getString(2);
                int age = rs1.getInt(3);
                String city = rs1.getString(4);
                String password = rs1.getString(5);
                result.add(new User(id, name, age, city, password));
            }
            System.out.println(result);

            System.out.println("===");

            PreparedStatement getUser = c.prepareStatement("select * from public.user where id = ?");
            getUser.setInt(1, 1);
            ResultSet rs2 = getUser.executeQuery();
            while (rs2.next()) {
                System.out.println(args[0] + ": " + rs2.getString(args[0]));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "apps", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
