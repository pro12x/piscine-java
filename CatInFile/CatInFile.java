import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }
        
        String filename = args[0];
        try (OutputStream out = new FileOutputStream(filename)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = System.in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
