import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {
    public static List<Integer> sort(List<Integer> list) {
        if (list == null) return null;

        List<Integer> result = new ArrayList<>(list);
        result.sort(Integer::compareTo);
        return result;
    }

    public static List<Integer> sortReverse(List<Integer> list) {
        if (list == null) return null;

        List<Integer> result = new ArrayList<>(list);
        result.sort(Integer::compareTo);
        Collections.reverse(result);
        return result;
    }
}
