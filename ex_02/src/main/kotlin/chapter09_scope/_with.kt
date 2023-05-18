package chapter09_scope

// 결과 반환 없이 내부에서 수신 객체를 이용해서 다른 함수를 호출하고 싶을 때 사용
// with는 확장 함수가 아님
// run과 유사하지만 with는 확장 함수가 아니다

fun main() {

    val str = "안녕하세요"

    val length: Int = with(str) {
        length // str의 length
    }
    println(length)

}