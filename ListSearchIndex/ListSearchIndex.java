import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListSearchIndex {
    public static Integer findLastIndex(List<Integer> list, Integer value) {
        return (list == null) ? null : (list.lastIndexOf(value) == -1 ? null : list.lastIndexOf(value));
    }

    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        return (list == null) ? null : (list.indexOf(value) == -1 ? null : list.indexOf(value));
    }

    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        if (list == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i), value)) {
                result.add(i);
            }
        }

        return result;
    }
}
