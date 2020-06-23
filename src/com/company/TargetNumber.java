package com.company;

public class TargetNumber {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    private int dfs(int[] numbers, int node, int sum, int target){
        if(node == numbers.length){ // 노드의 차수가 5
            if(sum==target) //
                return 1;
            return 0;
        }
        return dfs(numbers, node+1, sum + numbers[node], target)
                + dfs(numbers, node+1, sum - numbers[node], target);
    }
    public static void main(String[] args) {
        TargetNumber targetNumber = new TargetNumber();
        targetNumber.solution(new int[]{1,1,1,1,1}, 3);
    }
}
