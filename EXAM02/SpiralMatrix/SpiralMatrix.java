public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        // Implementation to generate a spiral matrix
        int[][] matrix = new int[n][n];

        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int value = 1;

        while(top <= bottom && left <= right) {
            // Ici, je vais de la gauche vers la droite en haut
            for(int i = left; i <= right; i++) {
                matrix[top][i] = value++;
            }
            top++; // Je descends vers le bas

            // Ici, je vais du haut vers le bas à droite
            for(int i = top; i <= bottom; i++) {
                matrix[i][right] = value++;
            }
            right--; // Je vais de la droite vers la gauche

            if (top <= bottom) {
                // Ici, je vais de la droite vers la gauche en bas
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = value++;
                }
                bottom--; // Je vais du bas vers le haut
            }

            if (left <= right) {
                // Ici, je vais du bas vers le haut à gauche
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = value++;
                }
                left++; // Je vais de la gauche vers la droite
            }
        }

        return matrix;
    }
}
