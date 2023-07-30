package org.example.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BaekJoon2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int d = Integer.parseInt(inputs[1]);
        int k = Integer.parseInt(inputs[2]);
        int c = Integer.parseInt(inputs[3]);

        String[] sushi = new String[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = br.readLine();
        }
        HashSet<String> l = new HashSet<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            int start = i;
            int end = i + k;

            if (end > N){
                for (int j = start; j < N; j++) {
                        l.add(sushi[j]);
                }
                for (int j = 0; j < end-N; j++) {
                        l.add(sushi[j]);
                }
            } else if (end > start) {
                for (int j = start; j < end; j++) {
                        l.add(sushi[j]);
                }
            }
            l.add(String.valueOf(c));
            if (l.size() > max)
                max = l.size();
            l.clear();
        }
        System.out.println(max);
    }
}

