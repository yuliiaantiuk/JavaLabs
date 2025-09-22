public class Matrix {

    public static void main(String[] args) {
        try {
            // Create matrix
            byte[][] B = {
                    {3, 5, 1, 4, -2},
                    {7, 2, 8, 10, 24},
                    {4, 6, 9, 0, 5},
                    {15, 4, 2, 7, 3}
            };

            // Transpose function
            byte[][] C = transpose(B);

            // Print transposed matrix
            System.out.println("C=B^T: ");
            printMatrix(C);

            // Sum of min elements
            int sumOfMins = sumOfRowMins(C);

            // Print result
            System.out.println("The sum of the minimum row elements of the matrix C: " + sumOfMins);

        } catch (Exception e) {
            // Error handling
            System.err.println("An error occured!: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Transpose matrix method
    private static byte[][] transpose(byte[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Matrix is null or undefined");
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        byte[][] transposed = new byte[cols][rows];

        if (rows >= 50 || cols >= 50) {
            throw new IllegalArgumentException("Matrix is too large");
        }

        // All rows must have equal length
        for (int i = 0; i < rows; i++) {
            if (matrix[i].length != cols) {
                throw new IllegalArgumentException("Matrix is not valid");
            }
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    // Print matrix
    private static void printMatrix(byte[][] matrix) {
        for (byte[] row : matrix) {
            for (byte value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // Calculate the sum of minimal elements in every row
    private static int sumOfRowMins(byte[][] matrix) {
        int sum = 0;
        for (byte[] row : matrix) {
            byte min = row[0];
            for (byte value : row) {
                if (value < min) {
                    min = value;
                }
            }
            sum += min;
        }
        return sum;
    }
}
