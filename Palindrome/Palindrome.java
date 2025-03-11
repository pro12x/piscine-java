public class Palindrome {
    public static boolean isPalindrome(String s) {
        return s.contentEquals(new StringBuilder(s).reverse()) && !s.trim().isEmpty();
    }
}
