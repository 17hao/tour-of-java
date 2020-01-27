package xyz.shiqihao.advanced.reflection.resource;

@A("class")
public class C {
    @A("field")
    int aField;

    @A("method")
    void aMethod(@A("param") String param) {
    }
}
