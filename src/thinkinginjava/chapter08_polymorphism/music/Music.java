package thinkinginjava.chapter08_polymorphism.music;

public class Music {
    private static void tune(Instrument i) {
        i.play(Note.C_CHARP);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute);
    }
}
