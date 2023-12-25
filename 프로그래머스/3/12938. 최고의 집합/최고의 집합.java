import java.util.*;
class Solution {
   public int[] solution(int n, int s) {
        int[] answer;
        if (n > s) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[n];
            int val = s / n;
            Arrays.fill(answer, val);
            if (s % n != 0) { 
                int a = s % n;
                for (int i = answer.length-a; i < answer.length; i++) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}