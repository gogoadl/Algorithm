package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int idx = 0;
        for(int i = people.length - 1; i >= idx; i--)
        {
            if(people[idx] + people[i] > limit)
                answer++;
            else
            {
                answer++;
                idx++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        LifeBoat lifeBoat = new LifeBoat();
        lifeBoat.solution(new int[]{70,81,50},100);
    }
}
