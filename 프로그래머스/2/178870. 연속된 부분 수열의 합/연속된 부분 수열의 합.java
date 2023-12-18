import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer;
        ArrayList<int[]> list = new ArrayList<>();
        // k 보다큰 값 제외
        int sum = 0;
        int start = 0;
        int end  = 0;
        while (start <= end && end < sequence.length) {
            if (sum == k) {
                list.add(new int[]{start,end-1});
            }
            if (sum + sequence[end] <= k) {
                sum += sequence[end];
                end++;
            } else {
                sum -= sequence[start];
                start++;
            }
        }
        if (sum == k) {
            list.add(new int[]{start,end-1});
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1]- o1[0]) - (o2[1] - o2[0]);
            }
        });

        answer = list.get(0);
        return answer;
    }
}