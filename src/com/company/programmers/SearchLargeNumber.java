package com.company.programmers;

public class SearchLargeNumber {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int value = -1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (j == numbers.length)
                    break;
                if (numbers[i] < numbers[j]) {
                    value = numbers[j];
                    break;
                } else if (numbers[i] == numbers[j]) {
                    continue;
                } else {
                    break;
                }
            }
            answer[i] = value;
        }
        return answer;
    }

    public static void main(String[] args) {
        SearchLargeNumber searchLargeNumber = new SearchLargeNumber();
        searchLargeNumber.solution(new int[]{ 2, 3, 3, 5});
    }
}
