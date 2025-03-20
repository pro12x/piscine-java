import java.util.List;

public class ListEquals {
    public static boolean areListsEqual(List<String> list1, List<String> list2) {
        return (list1 == null && list2 == null) ? true : ((list1 == null || list2 == null) ? false : list1.equals(list2));
    }
}
