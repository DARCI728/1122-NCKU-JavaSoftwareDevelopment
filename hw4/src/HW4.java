import java.util.Scanner;

public class HW4 {
    static int n = 0;
    static double[] deltas;
    static double[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.next());
        deltas = new double[n + 1];
        matrix = new double[n][n + 1];

        int i = 0, j = 0;
        while (true) {
            double value = Double.parseDouble(sc.next());

            if (value == -999)
                break;

            matrix[i][j++] = value;

            if (j == n + 1) {
                i++;
                j = 0;
            }
        }

        sc.close();

        int k = 0;
        while (k < n + 1) {
            int t = 0;
            double[][] delta_matrix = new double[n][n];

            for (i = 0; i < n; i++) {
                for (j = 0; j < n + 1; j++) {
                    if (j != k) {
                        delta_matrix[i][t++] = matrix[i][j];
                    }
                }

                t = 0;
            }

            deltas[k++] = Determin(delta_matrix);
        }

        boolean infinite_sol = true;

        for (double delta : deltas) {
            if (delta != 0) {
                infinite_sol = false;
                break;
            }
        }

        if (infinite_sol) {
            System.out.println("Infinite solutions");
            return;
        }

        if (deltas[n] == 0) {
            System.out.println("No solution");
        } else {
            System.out.println("The only solution");
        }
    }

    public static double Determin(double[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        }

        int sign = 1;
        double result = 0;

        for (int i = 0; i < n; i++) {
            double[][] subMatrix = CreateSubMatrix(matrix, i);
            result += sign * matrix[0][i] * Determin(subMatrix);
            sign *= -1;
        }

        return result;
    }

    private static double[][] CreateSubMatrix(double[][] matrix, int excludeCol) {
        int n = matrix.length;
        double[][] subMatrix = new double[n - 1][n - 1];

        for (int i = 1; i < n; i++) {
            int k = 0;

            for (int j = 0; j < n; j++) {
                if (j == excludeCol) {
                    continue;
                }

                subMatrix[i - 1][k] = matrix[i][j];
                k++;
            }
        }

        return subMatrix;
    }
}