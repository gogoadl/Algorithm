class Solution {
    fun solution(numbers: IntArray): Int {
        var answer = 0
        val sortedNumbers = numbers.sortedArray()
        for (i in 0..9) {
            if (!sortedNumbers.contains(i)) {
                answer += i
            }
        }
        return answer
    }
}