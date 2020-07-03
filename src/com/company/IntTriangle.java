package com.company;

public class IntTriangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[] tmp = triangle[0].clone();
        for(int i = 0; i < triangle.length - 1; i++)
        {

            int[] arr = new int[triangle[i].length * 2];
            for(int j = 0; j < arr.length; j++)
            {

                arr[j] = tmp[i] + triangle[i + 1][j];
            }
            tmp = arr.clone();
        }

        return answer;
    }
    public static void main(String[] args) {
        IntTriangle intTriangle = new IntTriangle();
        intTriangle.solution(new int[][]{{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}});
    }
}
