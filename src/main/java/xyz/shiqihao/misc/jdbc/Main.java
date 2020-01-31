package xyz.shiqihao.misc.jdbc;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用JDBC的模板流程:
 * 1. 获取Connection(DataSource是更推荐的方式)
 * 2. 创建Statement/PreparedStatement
 * 3. 执行步骤2中的对象, 获取ResultSet
 * 4. 对ResultSet进行处理
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
                System.out.println("id: 1, name: " + rs2.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = new PooledDataSource("org.postgresql.Driver",
                    "jdbc:postgresql://localhost:5432/postgres",
                    "apps", "").getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
