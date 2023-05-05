package com.company.programmers;

import java.util.Arrays;

public class Sort1 {
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length]; // commands의 길이에 따라 정답의 길이가 정해짐
        for(int i =0; i < commands.length; i++)
        {
            int[] arr = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]); // i부터 j까지 배열을 생성
            Arrays.sort(arr); // 생성한 배열을 정렬해주고
            answer[i] = arr[commands[i][2]-1]; // 정답 배열의 i 번째 인덱스에 생성한 배열의 commands의 k번째 값 을 넣어준다
        }


        return answer;
    }

    public static void main(String[] args) {
        Sort1 s = new Sort1();

        int[] a = s.solution(new int[]{1,5,2,6,3,7,4},new int[][]{{2,5,3,},{4,4,1},{1,7,3}});

    }

}