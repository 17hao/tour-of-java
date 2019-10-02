package xyz.shiqihao.misc.anonymous;

public class MethodReference {
    interface Bicycle {
        void run(long distance);
    }

    Bicycle racingBicycle = new Bicycle() {
        int ranking = 1;

        @Override
        public void run(long distance) {
            System.out.println("ranking: " + ranking + " run: " + distance);
        }
    };

    /*
     * method reference
     *
     * In the case where all your lambda expression does is
     * call another method with parameters passed to the lambda.
    */
    Bicycle mountainBicycle = System.out::println;

    public static void main(String[] args) {
        MethodReference demo = new MethodReference();
        demo.racingBicycle.run(1000);
        demo.mountainBicycle.run(10);
    }
}
