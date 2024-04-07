class Solution {
fun solution(numbers: IntArray): Int = (0..9).filterNot(numbers::contains).sum()
}