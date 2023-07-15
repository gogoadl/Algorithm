package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SWEA1961 {
    public static String[][] rotateMatrix(String[][] matrix) {
        String[][] rotated = new String[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                rotated[i][j] = matrix[matrix.length - j - 1][i];
            }
        }
        return rotated;
    }

    public static String toString(String[][] matrix, int index){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append(matrix[index][i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());


        for (int i = 1; i <= testCaseCount; i++) {
            StringBuilder answer = new StringBuilder();
            int matrixSize = Integer.parseInt(br.readLine());
            String [][] matrix = new String[matrixSize][matrixSize];
            for (int j = 0; j < matrixSize; j++) {
                matrix[j] = br.readLine().split(" ");
            }
            String[][] rotation90 = rotateMatrix(matrix);
            String[][] rotation180 = rotateMatrix(rotation90);
            String[][] rotation270 = rotateMatrix(rotation180);
            for (int j = 0; j < matrixSize; j++) {
                answer.append(toString(rotation90, j));
                answer.append(" ");
                answer.append(toString(rotation180, j));
                answer.append(" ");
                answer.append(toString(rotation270, j));
                answer.append("\n");
            }
            sb.append(String.format("#%d \n%s",i, answer));
        }
        System.out.println(sb);
    }
}
