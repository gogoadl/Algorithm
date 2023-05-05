package com.company.programmers


// block 클래스 생성
// block 클래스는 array를 가짐.
// 2. size 큰 순서부터 끼워넣기
//
class WeeklyChallenge_3 {
    fun solution(game_board: Array<IntArray>, table: Array<IntArray>): Int {
        var answer: Int = -1

        var blockArray = ArrayList<Block>()

        blockArray = findBlock(table, blockArray)

        return answer
    }

    fun findBlock(table: Array<IntArray>, blockArray: ArrayList<Block>): ArrayList<Block>{
        // block 클래스 생성하여
        val size = table.size


        return blockArray
    }

    class Block {
        var pos = ArrayList<Int>()
    }
}
fun main() {
    var weeklychallenge = WeeklyChallenge_3()

    weeklychallenge.solution(
        arrayOf(
            intArrayOf(1,1,0,0,1,0),
            intArrayOf(0,0,1,0,1,0),
            intArrayOf(0,1,1,0,0,1),
            intArrayOf(1,1,0,1,1,1),
            intArrayOf(1,0,0,0,1,0),
            intArrayOf(0,1,1,1,0,0)),
        arrayOf(
            intArrayOf(1,0,0,1,1,0),
            intArrayOf(1,0,1,0,1,0),
            intArrayOf(0,1,1,0,1,1),
            intArrayOf(0,0,1,0,0,0),
            intArrayOf(1,1,0,1,1,0),
            intArrayOf(0,1,0,0,0,0))
    )
}