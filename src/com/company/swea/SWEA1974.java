package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());
        int sudokuSize = 9;
        int checkMiniSize = 3;
        for (int i = 1; i <= testCaseCount; i++) {
            int answer = 1;
            String[][] sudoku = new String[sudokuSize][sudokuSize];
            ArrayList<String> checker = new ArrayList<>();
            for (int j = 0; j < sudokuSize; j++) {
                sudoku[j] = br.readLine().split(" ");
            }

            // x index 검사
            for (int j = 0; j < sudokuSize; j++) {
                for (int k = 0; k < sudokuSize; k++) {
                    if (checker.contains(sudoku[j][k])) {
                        answer = 0;
                        break;
                    }
                    checker.add(sudoku[j][k]);
                }
                checker.clear();
            }

            // y index 검사
            for (int j = 0; j < sudokuSize; j++) {
                for (int k = 0; k < sudokuSize; k++) {
                    if (checker.contains(sudoku[k][j])) {
                        answer = 0;
                        break;
                    }
                    checker.add(sudoku[k][j]);
                }
                checker.clear();
            }

            // 3x3 검사
            for (int j = 0; j < sudokuSize; j+= checkMiniSize) {
                for (int k = 0; k < sudokuSize; k+= checkMiniSize) {
                    for (int l = 0; l < checkMiniSize; l++) {
                        for (int m = 0; m < checkMiniSize; m++) {
                            if (checker.contains(sudoku[j + l][k + m])) {
                                answer = 0;
                                break;
                            }
                            checker.add(sudoku[j + l][k + m]);
                        }
                    }
                    checker.clear();
                }
            }
            sb.append(String.format("#%d %d\n", i, answer));
        }
        System.out.println(sb);
    }
}
