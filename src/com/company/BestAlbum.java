package com.company;

import java.util.HashMap;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<Integer,String> genreHashMap = new HashMap();
        HashMap<Integer,Integer> playsHashMap = new HashMap();
        
        for (int i = 0; i < genres.length; i++) {
            genreHashMap.put(i,genres[i]);
            playsHashMap.put(i,plays[i]);
        }

        for (int i: playsHashMap.values()) {
            System.out.print(i);
        }

        genreHashMap.size();
        return answer;
    }
    public static void main(String[] args) {
        BestAlbum bestAlbum = new BestAlbum();
        bestAlbum.solution(new String[]{"classic","pop","classic","classic","pop"}, new int[]{500,600,150,800,2500});
    }
}
