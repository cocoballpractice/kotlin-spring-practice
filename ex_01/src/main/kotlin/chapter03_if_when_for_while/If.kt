package chapter03_if_when_for_while

fun main() {

    /**
     * 코틀린에서의 if..else는 '식'이므로 리턴값을 반환할 수 있음
     * 자바에서의 if..else는 '구문'이므로 리턴값을 반환할 수 없음
     */

    // if..else 사용
    val job = "Software Developer"

    if (job == "Software Developer") {
        println("개발자")
    } else {
        println("개발자 아님")
    }

    // 코틀린의 if...else는 표현식
    val age : Int = 10

    val str = if (age > 10) {
        "성인"
    } else {
        "응애"
    }

    // 코틀린은 삼항 연산자가 없음. if..else가 표현식이므로 불필요
    val a = 1
    val b = 2
    val c = if (b > a) b else a

}