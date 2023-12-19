
import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        // stack + 뒤에서 접근 한다면 풀릴거같다.
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> result = new Stack<>();

        // 가장 마지막 원소는 항상 -1이다.
        stack.add(numbers[numbers.length-1]);
        result.add(-1);
        for (int i = numbers.length - 2 ; i >= 0; i--) {
            while(!stack.isEmpty()) {
                if (stack.peek() > numbers[i]) {
                    result.add(stack.peek());
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty())
                result.add(-1);

            stack.add(numbers[i]);
        }
        
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = result.pop();
        }
        return answer;
    }
}
