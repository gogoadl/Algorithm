package com.company;

import java.util.HashSet;
import java.util.Set;

public class Phoneketmon {
    public int solution(int[] nums) {
        int answer = nums.length / 2;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if(answer > set.size())
            answer = set.size();
        return answer;
    }

    public static void main(String[] args) {
        Phoneketmon phoneketmon = new Phoneketmon();
        phoneketmon.solution(new int[]{3,1,2,3});
    }
}

// 최대한 많은 수의 포켓몬을 골라야 하기 때문에, 중복을 제거해준다.
// 가질 수 있는 최댓값은 N/2 마리 이므로, 배열의 길이 / 2 가 최대값이다.
// 중복을 제거한 포켓몬 수 보다 최댓값이 크면 중복을 제거한 포켓몬 수가 최대값이 된다.