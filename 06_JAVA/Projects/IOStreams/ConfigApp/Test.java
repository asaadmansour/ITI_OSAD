import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;
import java.nio.file.Files;
public  class Test {
    public static String getValueFromConfigMap(Path configMapFilePath, String keyName) throws IOException {
        Properties properties = new Properties();
        try(InputStream inputStream = Files.newInputStream(configMapFilePath)) {
            properties.load(inputStream);
            String value = properties.getProperty(keyName);
            return (value != null) ? value.trim() : null;
        }

    }
}