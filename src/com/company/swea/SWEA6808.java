package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA6808 {
    static int[] cards;
    static int[] arr;
    static int[] selected;
    static boolean[] selectedCard;
    static int count = 1;
    static int loseCount = 0;
    static void makePermutation(int [] arr,int R, int cnt, int flag) {
        if(cnt==R) {
            int s1 = 0;
            int s2 = 0;
            for (int i = 0; i < cards.length; i++) {
                if (cards[i] < selected[i]) {
                    s1 += cards[i] + selected[i];
                } else {
                    s2 += cards[i] + selected[i];
                }
            }
            if (s1 < s2)
                loseCount++;
        } else {
            for(int i=0;i<arr.length;i++) {
                if((flag&1<<i)!=0) continue; //i번째 플래그가 1인 경우
                selected[cnt]=arr[i];
                makePermutation(arr, R, cnt+1, flag|1<<i); //i번째 플래그를 1로
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(st.nextToken());
        int R = 9;
        for (int i = 1; i <= R; i++) {
            count *= i;
        }
        for (int i = 1; i <= testCaseCount; i++) {
            st = new StringTokenizer(br.readLine());


            cards = new int[R];
            arr = new int[R];
            selected = new int[R];
            selectedCard = new boolean[R*2+1];
            loseCount = 0;
            int idx = 0;

            for (int j = 0; j < 9; j++) {
                cards[j] = Integer.parseInt(st.nextToken());
                selectedCard[cards[j]] = true;
            }
            for (int j = 1; j <= 18; j++) {
                if (!selectedCard[j])
                    arr[idx++] = j;
            }

            makePermutation(arr,R,0,0);
            sb.append(String.format("#%d %d %d\n", i,  loseCount, count - loseCount));
        }
        System.out.println(sb);
    }
}