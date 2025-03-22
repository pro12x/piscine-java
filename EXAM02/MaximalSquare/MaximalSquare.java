public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        // Implementation to find the area of the largest square containing only 1's
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSide = 0;

        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        MaximalSquare finder = new MaximalSquare();

        // Test case 1
        char[][] matrix1 = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println("Maximal square area: " + finder.maximalSquare(matrix1)); // Expected output: 4

        // Test case 2
        char[][] matrix2 = {
                {'0', '1'},
                {'1', '0'}
        };
        System.out.println("Maximal square area: " + finder.maximalSquare(matrix2)); // Expected output: 1

        // Test case 3
        char[][] matrix3 = {
                {'0'}
        };
        System.out.println("Maximal square area: " + finder.maximalSquare(matrix3)); // Expected output: 0
    }
}
