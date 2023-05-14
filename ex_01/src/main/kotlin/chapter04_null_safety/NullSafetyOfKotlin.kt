package chapter04_null_safety

fun getNullStr() : String? = null
fun getLengthIfNotNull(str: String?) = str?.length ?: 0 // 엘비스 연산자 사용, null일 경우 0 반환

fun main() {

    val nullableStr = getNullStr()

    // val nullableStrLength = nullableStr.length // 컴파일 에러 발생, nullable하기 때문
    val nullableStrLength = nullableStr?.length ?: "null인 경우 반환".length
    println(nullableStrLength)

    val length = getLengthIfNotNull(null)
    println(length)

    // NPE가 발생할 수 있는 코드
    throw NullPointerException() // 직접 호출

    val c: String? = null
    val d = c!!.length // 단언 연산자 !! 사용, null이 발생하지 않을 것이라고 확신할 경우

    println(NullSafetyOfJava.getNullStr().length) // 자바 클래스 내의 메서드 호출 (코틀린 컴파일러가 null 가능성 체크 못함)
}