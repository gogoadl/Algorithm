class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var max_v = 0
        var max_h = 0
        for (i in sizes) {
            val v = Math.max(i[0], i[1])
            val h = Math.min(i[0], i[1])
            max_v = Math.max(max_v, v)
            max_h = Math.max(max_h, h)
        }
        return max_v * max_h
    }
}