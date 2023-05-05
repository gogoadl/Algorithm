package com.company.programmers;

import java.util.ArrayList;
import java.util.Collections;

public class IslandTrip {
    int[][] array;
    ArrayList<Integer> answer= new ArrayList();
    public int dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= array.length || j >= array[i].length)
            return 0;

        if (array[i][j] == -1)
            return 0;

        int tmp = array[i][j];
        array[i][j] = -1;

        return tmp + dfs(i-1, j) + dfs(i+1, j) + dfs(i, j-1) + dfs(i, j+1);
    }

    public int[] solution(String[] maps) {
        array = new int[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char c = maps[i].charAt(j);
                if (c == 'X')
                    array[i][j] = -1;
                else
                    array[i][j] = c - '0';
            }
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                int sum = dfs(i, j);
                if (sum > 0)
                    answer.add(sum);
            }
        }

        if (answer.size() == 0) return new int[]{-1};

        Collections.sort(answer);
        int[] answerArray = new int[answer.size()];

        for (int i = 0; i < answerArray.length; i++) {
            answerArray[i] = answer.get(i);
        }

        return answerArray;
    }

    public static void main(String[] args) {
        IslandTrip islandTrip = new IslandTrip();
        islandTrip.solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"});
    }
}
