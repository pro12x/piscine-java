import java.util.List;

public class ListEquals {
    public static boolean areListsEqual(List<String> list1, List<String> list2) {
        return (list1 == null && list2 == null) ? true : ((list1 == null || list2 == null) ? false : list1.equals(list2));
    }

    public static void main(String[] args) {
        System.out.println(List.of("Alice", "Bob", "Charly", "Emily").equals(List.of("Alice", "Bob", "Charly", "Emily")));
        System.out.println(List.of("Alice", "Bob", "Charly", "Emily").equals(List.of("Alice", "Bob", "Emily", "Charly")));
        System.out.println(ListEquals.areListsEqual(List.of(), List.of("Alice", "Bob", "Charly", "Emily")));
        System.out.println(ListEquals.areListsEqual(List.of("Alice", "Bob", "Charly", "Emily"), List.of("Alice", "Bob", "Charly", "Emily")));
        System.out.println(ListEquals.areListsEqual(List.of("Alice", "Bob", "Charly", "Emily"), List.of()));
        System.out.println(ListEquals.areListsEqual(List.of("Alice", "Bob", "Charly", "Emily"), List.of("Alice", "Bob", "Emily", "Charly")));
    }
}
