class Solution {
    fun solution(n: Int): Int {
        var answer: Int = Int.MAX_VALUE;
        for (i in 1..n) {
            if (n % i == 1) {
                answer = Math.min(answer, i);
            }
        }

        return answer
    }
}