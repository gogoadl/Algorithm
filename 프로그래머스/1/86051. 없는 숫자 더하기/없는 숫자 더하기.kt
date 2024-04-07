class Solution {
    fun solution(numbers: IntArray): Int {
        var answer: Int = -1
        var sum = 0
        for(i in 0..numbers.size-1){
            sum += numbers[i]
        }
        answer = 45 - sum
        return answer
    }
}