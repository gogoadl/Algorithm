import java.util.Comparator;
import java.util.PriorityQueue;
class Solution {
       public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < works.length; i++) {
            queue.add(works[i]);
        }
        while (n != 0 ) {
            if (queue.peek() == 0) break;
            queue.add(queue.poll()-1);
            n--;
        }
        while (!queue.isEmpty()) {
            int val = queue.poll();
            answer += val*val;
        }
        return answer;
    }
}