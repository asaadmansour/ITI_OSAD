import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try {

            Path path = Path.of("./config.txt");
            Path path2 = Path.of("./");
            String dbUn = Test.getValueFromConfigMap(path,"database.user");
            String dbPw = Test.getValueFromConfigMap(path,"database.password");
            String discount = Test.getValueFromConfigMap(path,"discount");
            System.out.println(dbUn);
            System.out.println(dbPw);
            System.out.println(discount);
            System.out.println(FilesCount.getNumberOfFilesWithExtension(path2, ".java"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
