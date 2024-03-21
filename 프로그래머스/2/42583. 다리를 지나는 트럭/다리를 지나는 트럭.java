import java.util.*;

class Solution {
   public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> bridgeQueue = new LinkedList<>();
        Queue<Integer> waitQueue = new LinkedList<>();

        for (int i: truck_weights) {
            waitQueue.add(i);
        }
        int sum = 0;
        while (!waitQueue.isEmpty()){
            answer++;
            if(bridgeQueue.size() < bridge_length){
                if(sum + waitQueue.peek() <= weight){
                    sum += waitQueue.peek();
                    bridgeQueue.add(waitQueue.poll());

                }else{
                    bridgeQueue.add(0);
                }
            }else{
                sum -= bridgeQueue.poll();
                if(sum + waitQueue.peek() <= weight){
                    sum += waitQueue.peek();
                    bridgeQueue.add(waitQueue.poll());

                }else{
                    bridgeQueue.add(0);
                }
            }
        }
        return answer + bridge_length;
    }
}