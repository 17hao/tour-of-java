package xyz.shiqihao.mybatis;

import xyz.shiqihao.jdbc.User;
import xyz.shiqihao.mybatis.service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService service = new UserService();
        User u = new User();
        u.setName("mybatis");
        u.setAge(0);
        u.setPassword("mybatis");

        // service.insert(u);
        // service.delete(25);
        u.setPassword("mybatis-update");
        service.update(u, 28);
        // System.out.println(service.getUser(1));
        // System.out.println(service.getAllUsers());
    }
}
