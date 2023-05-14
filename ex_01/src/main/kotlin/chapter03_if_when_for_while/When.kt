package chapter03_if_when_for_while

fun main() {

    // 자바 코드 (switch 문 등, 다만 최근 JDK는 switch case return 가능)를 코틀린의 when 식으로 변환한 코드
    val day = 2

    val result = when (day) {
        1 -> "월요일"
        2 -> "화요일"
        3 -> "수요일"
        4 -> "목요일"
        else -> "기타"
    }

    println(result)

    // else 생략 가능
    when(getColor()) {
        Color.RED -> print("red")
        Color.GREEN -> print("green")
    }


    // 여러 개의 조건을 콤마로 구분해 한줄에서 정의 가능
    when(getNumber()) {
        0, 1 -> print("0 또는 1")
        else -> print("0 또는 1이 아님")
    }

}


enum class Color {
    RED, GREEN
}

fun getColor() = Color.RED

fun getNumber() = 2