public class Palindrome {
    public static boolean isPalindrome(String s) {
        return s != null && s.toLowerCase().contentEquals(new StringBuilder(s.toLowerCase()).reverse());
    }
}
