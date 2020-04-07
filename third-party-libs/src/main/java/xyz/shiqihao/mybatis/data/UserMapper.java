package xyz.shiqihao.mybatis.data;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.shiqihao.jdbc.User;

import java.util.List;

@Mapper
public interface UserMapper {
    public void insertUser(User user);

    public void deleteUser(Integer id);

    public void updateUser(@Param("user") User user, @Param("id") Integer id);

    public User getUser(Integer id);

    public List<User> getAllUsers();
}
