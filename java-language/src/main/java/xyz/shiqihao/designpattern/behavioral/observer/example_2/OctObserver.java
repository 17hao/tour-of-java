package xyz.shiqihao.designpattern.behavioral.observer.example_2;

public class OctObserver extends Observer {
    public OctObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal string: " + Integer.toOctalString(subject.getState()));
    }
}
