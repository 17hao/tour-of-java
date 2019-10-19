package xyz.shiqihao.misc.guava;

import com.google.common.base.Charsets;
import com.google.common.hash.*;

public class MurmurHash {
    public static void main(String[] args) {
        Person p = new Person("sqh", 22);
        Funnel<Person> personFunnel = (Funnel<Person>) (person, primitiveSink) -> primitiveSink.
                putString(person.name, Charsets.UTF_8)
                .putInt(person.age);
        HashFunction hf = Hashing.murmur3_128();
        Long hc = hf.newHasher().putObject(p, personFunnel).hash().asLong();
        System.out.println(hc);
    }
}

class Person {
    final String name;
    final int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
