package com.company.programmers;

import java.util.HashMap;

public class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 0;
        int sum = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < clothes.length; i++)
        {

            if(hashMap.containsKey(clothes[i][1]))
            {
                int a = hashMap.get(clothes[i][1]) + 1;
                hashMap.put(clothes[i][1],a);
            }else
            {
                hashMap.put(clothes[i][1],1);
            }

        }
        for( String key : hashMap.keySet())
        {

            sum *= hashMap.get(key) + 1;
        }
        answer = sum -1;
        return answer;
    }

    public static void main(String[] args) {
        Camouflage camouflage = new Camouflage();
        camouflage.solution(new String[][]{{"yellow_hat","headgear"},{"blue_sunglasses","headgear"},{"green_turban","headgear"}});
    }
}
