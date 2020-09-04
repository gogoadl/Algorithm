package com.company;

public class TargetNumber {
    public int dfs(int[] numbers, int target, int depth, int sum)
    {
        if (depth == numbers.length){
            if (sum == target)
            {
                return 1;
            }else
                return 0;
        }else {
            return dfs(numbers, target, depth + 1, sum + numbers[depth])
                    + dfs(numbers, target, depth + 1, sum - numbers[depth]);
        }
    }
    public int solution(int[] numbers, int target) {

        int answer = dfs(numbers, target, 0, 0);

        return answer;
    }
    public static void main(String[] args) {
        TargetNumber targetNumber = new TargetNumber();
        int a = targetNumber.solution(new int[]{1,2,3,4,5}, 7);
        System.out.print(a);
    }
}
