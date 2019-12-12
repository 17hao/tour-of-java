package xyz.shiqihao.advanced.jvm.parameter;

public class Config {
    public static void main(String[] args) {
        System.out.println("Max memory " + Runtime.getRuntime().maxMemory() / (1024 * 1024 * 1024) + " GB");
        System.out.println("CPU Cores: " + Runtime.getRuntime().availableProcessors());
    }
}
