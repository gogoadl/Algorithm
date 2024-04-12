import java.io.BufferedReader
import java.io.InputStreamReader

import java.util.StringTokenizer


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val N = st.nextToken().toDouble()
    val M = st.nextToken().toDouble()

    System.out.println(N.div(M))
}