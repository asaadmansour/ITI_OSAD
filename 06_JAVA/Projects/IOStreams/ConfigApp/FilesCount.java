import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FilesCount {
    public static long getNumberOfFilesWithExtension(Path pathToStartSearch, String extension) throws IOException {
        try (Stream<Path> stream = Files.find(pathToStartSearch, Integer.MAX_VALUE, 
            (path, attr) -> path.getFileName().toString().endsWith(extension))) {
            
            return stream.count(); 
        }
    }
}