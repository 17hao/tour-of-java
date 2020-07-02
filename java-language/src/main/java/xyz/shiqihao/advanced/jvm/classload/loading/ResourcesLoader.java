package xyz.shiqihao.advanced.jvm.classload.loading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Load resources from class path.
 */
public class ResourcesLoader {
    public static void main(String[] args) throws IOException {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (cl == null) {
            cl = ResourcesLoader.class.getClassLoader();
        }
        // URL resource = cl.getResource("configuration.xml");
        URL resource = cl.getResource("Test.groovy");
        if (resource == null) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.openStream()))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
            }
        }
    }
}
