package main.miscellaneous.anonymous;

/**
 * Local classes and Anonymous classes
 */
public class AnonymousClass {
    interface HelloWorld {
        void greet();

        void greetSomeone(String name);
    }

    public void sayHello() {
        class EnglishGreeter implements HelloWorld {
            @Override
            public void greet() {
                greetSomeone("american");
            }

            @Override
            public void greetSomeone(String someone) {
                System.out.println("hello: " + someone);
            }
        }
        EnglishGreeter englishGreeter = new EnglishGreeter();
        englishGreeter.greet();

        HelloWorld chineseGreeter = new HelloWorld() {

            @Override
            public void greet() {
                greetSomeone("chinese");
            }

            @Override
            public void greetSomeone(String name) {
                System.out.println("hi: " + name);
            }
        };
        chineseGreeter.greet();
    }

    public static void main(String[] args) {
        AnonymousClass demo = new AnonymousClass();
        demo.sayHello();
    }
}
