package com.company.programmers;


public class Practice23 { // 땅따먹기
    int solution(int[][] land) {
        int i0, i1, i2, i3;
        int[] max = { land[0][0],land[0][1], land[0][2], land[0][3] };

        for(int i = 1; i < land.length ; i++) {
            i0 = maxVal(max[1], max[2], max[3]) + land[i][0];
            i1 = maxVal(max[0], max[2], max[3]) + land[i][1];
            i2 = maxVal(max[1], max[0], max[3]) + land[i][2];
            i3 = maxVal(max[1], max[2], max[0]) + land[i][3];

            max[0] = i0;
            max[1] = i1;
            max[2] = i2;
            max[3] = i3;
        }

        int ans = 0;
        for(int i = 0 ; i < 4 ; i++) {
            if(ans < max[i]) {
                ans = max[i];
            }
        }

        return ans;
    }

    static int maxVal(int a1, int a2, int a3) {
        return Math.max( Math.max(a1, a2), a3 );
    }
    public static void main(String[] args) {
        Practice23 practice23 = new Practice23();
        practice23.solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}});
    }
}
