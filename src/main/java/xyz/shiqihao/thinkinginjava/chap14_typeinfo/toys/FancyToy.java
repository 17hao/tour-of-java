package xyz.shiqihao.thinkinginjava.chap14_typeinfo.toys;

class FancyToy extends Toy implements HasBatteries, Shoots, WaterProof {
    FancyToy() {
        super(1);
    }
}
