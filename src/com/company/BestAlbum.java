package com.company;

import java.util.HashMap;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<Integer,String> ghashMap = new HashMap();
        HashMap<Integer,Integer> phashMap = new HashMap();
        for (int i = 0; i < genres.length; i++) {
            ghashMap.put(i,genres[i]);
            phashMap.put(i,plays[i]);
        }


        return answer;
    }
    public static void main(String[] args) {
        BestAlbum bestAlbum = new BestAlbum();
        bestAlbum.solution(new String[]{"classic","pop","classic","classic","pop"}, new int[]{500,600,150,800,2500});
    }
}
