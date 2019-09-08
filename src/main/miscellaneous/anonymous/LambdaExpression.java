package main.miscellaneous.anonymous;

/**
 * lambda expression can replace interface that has only one abstract method.
 * the parameters and return type of the lambda expression match the single method.
 */
public class LambdaExpression {
    interface Hello {
        void greet(String content);
    }

    Hello hello = (content) -> System.out.println("He said: " + content);

    public static void main(String[] args) {
        LambdaExpression demo = new LambdaExpression();
        demo.hello.greet("lambda expression");
    }
}
