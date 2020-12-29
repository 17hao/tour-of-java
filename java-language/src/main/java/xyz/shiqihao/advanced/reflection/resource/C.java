package xyz.shiqihao.advanced.reflection.resource;

@A("class")
public class C implements I<String> {
    @A("field")
    int aField;

    @A("method")
    void aMethod(@A("param") String param) {
    }
}
