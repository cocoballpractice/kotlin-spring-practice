package chapter03_if_when_for_while

fun main() {

    // 범위 연산자 .. 를 사용해 for loop 돌리기
    // ..는 뒤에 있는 값도 포함됨 (아래 예제에서는 0, 1, 2, 3)
    for (i in 0 .. 3) {
        println(i) // 0, 1, 2, 3
    }

    // until을 사용해 반복
    // 뒤에 온 숫자는 포함하지 않음
    for (i in 0 until 3) {
        println(i) // 0, 1, 2
    }

    // step에 들어온 값 만큼 증가시킴
    for (i in 0 .. 6 step 2) {
        println(i) // 0, 2, 4, 6
    }

    // downTo를 사용해 반복하면서 값을 감소시킴
    for (i in 6 downTo 1) {
        println(i) // 6, 5, 4, 3, 2, 1
    }

    // 전달받은 배열을 반복
    val numbers = arrayOf(1,2,3)

    for (i in numbers) {
        println(i)
    }
}