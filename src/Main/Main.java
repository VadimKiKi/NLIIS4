package Main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Function f = new Function();
        Scanner in = new Scanner(System.in);
        double el;
        System.out.print("Введите размерность матрицы: ");
        int n = in.nextInt();
        double[][] A = new double[n][n];
        double[][] B = new double[n][n];
        int choice;
        System.out.print("Как заполнить матрицу бинарного отношения: 0 - рандом, 1 - вручную: ");
        choice = in.nextInt();
        switch (choice) {
            case 0: {
                f.randInput(A, n);
                f.randInput(B, n);
                break;
            }
            case 1: {
                System.out.println("Введите меры принадлежности для матрицы A:");
                f.handInput(A, n);
                System.out.println("Введите меры принадлежности для матрицы B:");
                f.handInput(B, n);
                break;
            }
            default: {
                System.out.println("Введено неверное значение!");
                return;
            }
        }
        System.out.println("Матрица А: ");
        f.output(A, n);
        System.out.println();
        System.out.println("Матрица B: ");
        f.output(B, n);
        System.out.println();

        double[][] Composition = f.createComposition(A, B, n);
        System.out.println("Композиция матриц А и В: ");
        f.output(Composition,n);
        System.out.println();

        System.out.print("Введите альфа: ");
        double alpha = in.nextDouble();
        System.out.println("Альфа-срез для матрицы А: ");
        f.alphaSrez(A,n,alpha);
        System.out.println();
        System.out.println("Альфа-срез для матрицы B: ");
        f.alphaSrez(B,n,alpha);
        System.out.println();
        System.out.println("Альфа-срез для композиции: ");
        f.alphaSrez(Composition,n,alpha);
        System.out.println();
    }
}
