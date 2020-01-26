package xyz.shiqihao.misc.mybatis.service;

import org.apache.ibatis.session.SqlSession;
import xyz.shiqihao.misc.jdbc.User;
import xyz.shiqihao.misc.mybatis.util.MyBatisUtil;
import xyz.shiqihao.misc.mybatis.data.UserMapper;

import java.util.List;

public class UserService {
    private SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
    private UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

    public void insert(User user) {
        userMapper.insertUser(user);
        sqlSession.commit();
        System.out.println("insert successfully");
    }

    public void delete(int id) {
        userMapper.deleteUser(id);
        sqlSession.commit();
        System.out.println("delete successfully.");
    }

    public void update(User user, int id) {
        userMapper.updateUser(user, id);
        sqlSession.commit();
        System.out.println("update successfully.");
    }

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    public User getUser(int id) {
        return userMapper.getUser(id);
    }
}
