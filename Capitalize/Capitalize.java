import java.io.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Capitalize {
    private static String[] splitTab(String input) {
        String[] split = input.trim().split(" ");
        List<String> list = new ArrayList<>();

        for (String s : split) {
            if (!s.trim().isEmpty()) {
                list.add(s.trim().substring(0, 1).toUpperCase() + s.trim().substring(1).toLowerCase());
            }
        }

        String[] result = new String[list.size()];
        int i = 0;
        for (String s : list) {
            result[i] = s;
            i++;
        }

        return result;
    }

    public static void capitalize(String[] args) throws IOException {
        String inputFile = args[0];
        String outputFile = args[1];

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tab = Capitalize.splitTab(line);
                writer.write(String.join(" ", tab));
                writer.newLine();
            }
        }
    }

    /*public static void main(String[] args) throws IOException {
        Capitalize.capitalize(new String[]{"input", "output"});
        String expectedResult = new String(Files.readAllBytes(Paths.get("result")));
        String userOutput = new String(Files.readAllBytes(Paths.get("output")));
        System.out.println(expectedResult.equals(userOutput));
    }*/
}
