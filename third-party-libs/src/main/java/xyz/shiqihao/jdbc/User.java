package xyz.shiqihao.jdbc;

public class User {
    private int id;
    private String name;
    private int age;
    private String city;
    private String password;

    /**
     * java bean需要一个默认的无参构造方法, 当显示提供
     * 一个有参构造方法时, 除非显示定义否则无参构造方法会失效.
     */
    public User() {
    }

    /**
     * mybatis查询数据库部分字段返回null时, 可以添加一个为null值对应字段赋值的构造方法.
     */
    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.age = 0;
        this.city = null;
        this.password = password;
    }

    public User(int id, String name, int age, String city, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
