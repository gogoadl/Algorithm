package com.company.programmers

import kotlin.collections.HashMap
import kotlin.math.abs

class WeeklyChallenge_4 {
    fun solution(table: Array<String>, languages: Array<String>, preference: IntArray): String {

        var hashMap = HashMap<String, Int>()
        for (i in table.indices) { // 첫번째 배열 아이템 나누기
            var tableArr = table[i].split(" ")
            var sum = 0

            for (j in languages.indices) {
                var idx = tableArr.indexOf(languages[j])
                if (idx != -1) {
                    var size = tableArr.size - idx
                    sum += size * preference[j]
                }
            }
            hashMap.put(tableArr[0],sum)
        }
        var maxVal = hashMap.values.maxOrNull()
        var answers = hashMap.filter { it.value == maxVal }
        return answers.keys.minOrNull()!!
    }
}

fun main() {


    var weeklyChallenge_4 = WeeklyChallenge_4()
    print(weeklyChallenge_4.solution(arrayOf(
        "SI JAVA JAVASCRIPT SQL PYTHON C#",
        "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
        "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
        "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
        "GAME C++ C# JAVASCRIPT C JAVA"),
        arrayOf("JAVA", "JAVASCRIPT"),
        intArrayOf(7,5)))
}