import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
        for (int i = 0; i < operations.length; i++) {
            String[] splited = operations[i].split(" ");
            if (splited[0].equals("I")) {
                maxQueue.add(Integer.parseInt(splited[1]));
                minQueue.add(Integer.parseInt(splited[1]));
            } else {
                if (splited[1].equals("1") && !maxQueue.isEmpty()) {
                    minQueue.remove(maxQueue.poll());
                } else if (splited[1].equals("-1") && !minQueue.isEmpty()) {
                    maxQueue.remove(minQueue.poll());
                }

            }
        }
        if (!maxQueue.isEmpty())
            answer[0] = maxQueue.poll();
        if (!minQueue.isEmpty())
            answer[1] = minQueue.poll();

        return answer;
    }
}