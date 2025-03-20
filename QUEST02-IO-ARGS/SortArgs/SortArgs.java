import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortArgs {
    public static void sort(String[] args) {
        List<String> list = Arrays.asList(args);
        list.sort(Comparator.comparingDouble(Double::parseDouble));
        System.out.println(String.join(" ", list));
    }
}
