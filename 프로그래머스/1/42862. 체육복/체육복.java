import java.util.Arrays;

class Solution {
          public int solution(int n, int[] lost, int[] reserve) {
        int lostCnt = lost.length;
        boolean[] rent = new boolean[n];


        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == lost[i]) {
                    lost[i] = -1;
                    rent[j] = true;
                    lostCnt--;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (!rent[j] && (reserve[j]+1 == lost[i] || reserve[j]-1 == lost[i])) {
                    lostCnt--;
                    rent[j] = true;
                    break;
                }
            }
        }
        System.out.println(n-lostCnt);
        return n-lostCnt;
    }
}