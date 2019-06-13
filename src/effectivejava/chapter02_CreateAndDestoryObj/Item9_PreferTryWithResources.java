package effectivejava.chapter02_CreateAndDestoryObj;

import java.io.*;

public class Item9_PreferTryWithResources {
    /**
     * try-finally: No longer the best way to close resources
     */
    private static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    /**
     * try-finally is ugly when used with more than one resource
     */
    private void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buffer = new byte[256];
                int n;
                while ((n = in.read(buffer)) >= 0) {
                    out.write(n);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    /**
     * try-with-resources: the best way to close resources
     */
    String firstLineOfFileV2(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    /** try-with-resources on multiple resources */
    void copyV2(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dst)) {
            byte[] buffer = new byte[256];
            int n;
            while ((n = in.read(buffer)) >= 0) {
                out.write(n);
            }
        }
    }

    public static void main(String[] args) {
        try {
            String res = firstLineOfFile("/Users/17hao/IdeaProjects/javacode/src/effectivejava/chapter02_CreateAndDestoryObj/Item9_PreferTryWithResources.java");
            System.out.println(res);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
