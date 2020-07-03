package com.company;

public class IntTriangle {
    public int solution(int[][] triangle) {
        int answer = 0;

        for(int i = 1; i < triangle.length; i++)
        {
            for (int j = 0; j < triangle[i].length; j++)
            {
                if(j == 0)
                {
                    triangle[i][j] += triangle[i - 1][j];
                }else if ( j == triangle[i].length - 1)
                {
                    triangle[i][j] += triangle[i - 1][j - 1];
                }
                else
                {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1],triangle[i - 1][j]);
                }
            }
        }
        int max = 0;
        for(int k = 0; k < triangle[triangle.length - 1].length; k++)
        {
            if (triangle[triangle.length - 1][k] > max)
                max = triangle[triangle.length - 1][k];
        }

        answer = max;

        return answer;
    }
    public static void main(String[] args) {
        IntTriangle intTriangle = new IntTriangle();
        intTriangle.solution(new int[][]{{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}});
    }
}
