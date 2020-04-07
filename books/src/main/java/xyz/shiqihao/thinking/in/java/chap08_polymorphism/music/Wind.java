package xyz.shiqihao.thinking.in.java.chap08_polymorphism.music;

class Wind extends Instrument {
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }
}
