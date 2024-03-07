//package com.company.programmers
//
//class WeeklyChallenge_2 {
//    fun solution(scores: Array<IntArray>): String {
//        var answer: String = ""
//        var rotatedScores : Array<IntArray> = Array(scores.size) { IntArray(scores.size)}
//
//        for ( i in scores.indices)
//            for (j in scores[i].indices)
//                rotatedScores[i][j] = scores[j][i]
//
//        for (i in scores.indices)
//        {
//            var sum = 0.0F
//            var cnt = rotatedScores[i].size
//
//            for ( j in rotatedScores[i].indices)
//            {
//                if (i == j)
//                {
//                    if (rotatedScores[i][j] == rotatedScores[j].minOrNull() ||
//                            rotatedScores[i][j] == rotatedScores[j].maxOrNull())
//                    {
//                        var countOfSameVal = rotatedScores[i].filter { it.equals(rotatedScores[i][j])}
//                        if (countOfSameVal.size < 2) {
//                            cnt -= 1
//                            continue
//                        }
//                    }
//                }
//                sum += rotatedScores[i][j]
//            }
//            sum /= cnt
//
//            when (sum) {
//                in 90F..100F -> answer = answer.plus("A")
//                in 80F..90F -> answer = answer.plus("B")
//                in 70F..80F -> answer = answer.plus("C")
//                in 50F..70F -> answer = answer.plus("D")
//                in  0F..50F -> answer = answer.plus("F")
//            }
//        }
//        return answer
//    }
//}
//fun main(args: Array<String>){
//    var weeklychallenge2 = WeeklyChallenge_2()
//    var a = arrayOf(intArrayOf(100,90,98,88,65),intArrayOf(50,45,99,85,77),intArrayOf(47,88,95,80,67),intArrayOf(61,57,100,80,65),intArrayOf(24,90,94,75,65))
//    var b = weeklychallenge2.solution(a)
//    print(b)
//}