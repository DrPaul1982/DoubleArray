package app;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[][] array = {{14, 21, 31, 7},
                {5, 11, 42, 13},
                {45, 26, 19, 18},
                {4, 37, 29, 8}};

        long sumInOddRows = 0;
        long sumInEvenRows = 0;
        long multiplyInOddCols = 1;
        long multiplyInEvenCols = 1;
        int mainDiagonalSum = 0;
        int secondaryDiagonalSum = 0;
        int arrayLen = array.length;
        int[] columnSums = new int[arrayLen];
        int[] rowSums = new int[arrayLen];

        System.out.println("Матриця 4х4: ");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                rowSums[i] += array[i][j];

                if (j % 2 == 0) {
                    multiplyInOddCols *= array[i][j];
                } else {
                    multiplyInEvenCols *= array[i][j];
                }
                columnSums[j] += array[i][j];

                System.out.print(array[i][j] + " ");
            }

            mainDiagonalSum += array[i][i];
            secondaryDiagonalSum += array[i][arrayLen - 1 - i];

            if (i % 2 == 0) {
                sumInOddRows += rowSums[i];
            } else {
                sumInEvenRows += rowSums[i];
            }
            System.out.println();
        }

        boolean isMagicSquare = true;



        if (mainDiagonalSum != secondaryDiagonalSum) {
            isMagicSquare = false;

        } else {
            for (int i = 0; i < rowSums.length; i++) {
                if (rowSums[i] != mainDiagonalSum || columnSums[i] != mainDiagonalSum) {
                    isMagicSquare = false;
                    break;
                }
            }
        }

        System.out.println("Сума елементів у парних рядках (рядок 0, 2): "+ sumInOddRows +
                "\nСума елементів у непарних рядках (рядок 1, 3): "+ sumInEvenRows
                +"\nДобуток елементів у парних стовпцях (стовпець 0, 2): " + multiplyInOddCols +
                "\nДобуток елементів у непарних стовпцях (стовпець 1, 3): " + multiplyInEvenCols);

        if (isMagicSquare) {
            System.out.println("Матриця є магічним квадратом.");}
        else {
            System.out.println("Матриця не є магічним квадратом.");
        }

    }
}
