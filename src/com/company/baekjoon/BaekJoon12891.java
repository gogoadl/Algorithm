package com.company.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        char[] s = st.nextToken().toCharArray();

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int a = 0;
        int c = 0;
        int g = 0;
        int t = 0;

        int start = 0;
        int end= P;
        for (int i = 0; i < P; i++) {
            if (s[i] == 'A') a++;
            else if (s[i] == 'C') c++;
            else if (s[i] == 'G') g++;
            else if (s[i] == 'T') t++;
        }
        while(end < S) {
            if (a >= A && c >= C && g >= G && t >= T)
                answer++;

            if (s[end] == 'A') a++;
            else if (s[end] == 'C') c++;
            else if (s[end] == 'G') g++;
            else if (s[end] == 'T') t++;
            end++;
            if (s[start] == 'A') a--;
            else if (s[start] == 'C') c--;
            else if (s[start] == 'G') g--;
            else if (s[start] == 'T') t--;
            start++;
        }
        if (a >= A && c >= C && g >= G && t >= T)
            answer++;
        System.out.println(answer);
    }
}