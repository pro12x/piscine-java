import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SteadySequence {
    public int longestSequence(int[] nums) {
        // Implementation to find the length of the longest consecutive elements sequence
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        SteadySequence finder = new SteadySequence();

        // Test case 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive sequence length: " + finder.longestSequence(nums1)); // Expected output: 4

        // Test case 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Longest consecutive sequence length: " + finder.longestSequence(nums2)); // Expected output: 9

        // Test case 3
        int[] nums3 = {1, 2, 0, 1};
        System.out.println("Longest consecutive sequence length: " + finder.longestSequence(nums3)); // Expected output: 3
    }
}
