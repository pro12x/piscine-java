import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Cat {
    public static void cat(String[] args) throws IOException {
        for (String filename : args) {
            try (InputStream inputStream = new FileInputStream(filename)) {
                byte[] buffer = new byte[2048];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    System.out.write(buffer, 0, bytesRead);
                }
            }
        }
    }
}
