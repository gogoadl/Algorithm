package com.company.programmers;

import java.util.Arrays;

public class InterceptSystem {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (target1, target2) -> {
            if(target1[1] == target2[1]){
                return target1[0] - target2[0];
            }
            return target1[1] - target2[1];
        });
        int interceptPoint = 0;
        for (int i = 0; i < targets.length; i++) {
            if (targets[i][0] < interceptPoint) {
            }
            else if (targets[i][1] > interceptPoint) {
                interceptPoint = targets[i][1];
                answer++;
            }
        }

        System.out.println(targets);
        return answer;
    }
    public static void main(String[] args) {
        InterceptSystem interceptSystem = new InterceptSystem();
        int[][] param = new int[][]{
                {4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}, {1,15}, {3,4}, {5,6}};
        int[][] param2 = new int[][]{
                {1,2},{2,3},{3,4}};
        System.out.println(interceptSystem.solution(param));
    }
}
