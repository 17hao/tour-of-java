package miscellaneous;

public class PassByValue {
    public static void main(String[] args) {
        Dog myDog = new Dog("aDog");
        Dog oldDog = myDog;
        foo(myDog);
        System.out.println(myDog.getName().equals("fooDog"));
        System.out.println(myDog.getName().equals("renameFooDog"));
        System.out.println(myDog.getName().equals("newDog"));
        System.out.println("#####");
        Dog d = bar(myDog);
        System.out.println(myDog.getName().equals("barDog"));
        System.out.println(myDog.getName().equals("renameBarDog"));
        System.out.println(oldDog == d);
    }

    private static void foo(Dog myDog) {
        myDog.setName("fooDog");
        myDog = new Dog("newDog");
        //myDog.setName("renameFooDog");
    }

    private static Dog bar(Dog myDog) {
        myDog.setName("barDog");
        myDog = new Dog("newDog");
        myDog.setName("renameBarDog");
        return myDog;
    }
}

class Dog {
    private String name;

    Dog(String name) {
        this.name = name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}