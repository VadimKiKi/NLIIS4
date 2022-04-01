package Main;

import java.util.Random;
import java.util.Scanner;

public class Function {

    public void randInput(double[][] matrix, int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double el;
                el = random.nextDouble();
                el = (double) (Math.round(el * 10)) / 10;
                matrix[i][j] = el;
            }
        }
    }

    public void handInput(double[][] matrix, int n) {
        Scanner in = new Scanner(System.in);
        double el;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Элемент (" + i + "," + j + "):");
                el = in.nextDouble();
                matrix[i][j] = el;
            }
        }
        System.out.println();
    }

    public void output(double[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public double[] line(double[][] matrix, int n, int index) {
        double[] line = new double[n];
        for (int i = 0; i < n; i++) {
            line[i] = matrix[index][i];
        }
        return line;
    }

    public double[] column(double[][] matrix, int n, int index) {
        double[] column = new double[n];
        for (int i = 0; i < n; i++) {
            column[i] = matrix[i][index];
        }
        return column;
    }

    public double searchMax(double[] temp, int n) {
        double max = temp[0];
        for (int i = 0; i < n; i++) {
            if (max < temp[i])
                max = temp[i];
        }
        return max;
    }

    public double composition(double[] line, double[] column, int n) {
        double[] minLine = new double[n];
        for (int i = 0; i < n; i++) {
            minLine[i] = Math.min(line[i], column[i]);
        }
        return (searchMax(minLine, n));
    }

    public double[][] createComposition(double[][] matrix1, double[][] matrix2, int n) {
        double[][] Composition = new double[n][n];
        for (int i = 0; i < n; i++) {
            double[] line = new double[n];
            line = line(matrix1, n, i);
            for (int j = 0; j < n; j++) {
                double[] column = new double[n];
                column = column(matrix2, n, j);
                Composition[i][j] = composition(line, column, n);
            }
        }
        return Composition;
    }

    public void alphaSrez(double[][] matrix, int n, double alpha) {
        System.out.print("{");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] >= alpha)
                    System.out.print("((" + (i + 1) + "," + (j + 1) + ")/" + matrix[i][j] + ")");
            }
        }
        System.out.println("}");
    }
}
