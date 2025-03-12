import java.io.*;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args.length < 2) {
            return;
        }

        String inputFile = args[0];
        File file = new File(inputFile);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + inputFile);
        }
        
        String outputFile = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            int c;
            while ((c = reader.read()) != -1) {
                writer.write(Character.toUpperCase((char) c));
            }
        }
    }
}
