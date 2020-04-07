package xyz.shiqihao.jedis;

class User {
    private String name;
    private int age;
    private String email;

    User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "name: " + name + ", age: " + age + ", email: " + email;
    }
}
