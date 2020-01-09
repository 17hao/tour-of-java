package xyz.shiqihao.basic.annotations;

public interface Executor {
    @Todo(author = "sqh", priority = Todo.Priority.LOW, status = Todo.Status.OPEN)
    @MyAnnotation(city = MyAnnotation.City.NINGBO, country = MyAnnotation.Country.CHINA)
    default String method(String... args) {
        return "default method";
    }
}
