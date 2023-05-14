package chapter04_null_safety

fun main() {

    // val a : String = null // 컴파일 오류

    var b : String = "aabbcc"
    // b = null // 지연 할당을 통해 null을 할당하려 해도 컴파일 오류

    var a : String? = null // Nullable 타입, 안전 연산자 '?'를 추가
    // a.length // 컴파일 오류, nullable하므로
    a?.length
    print(a?.length)

    // null 에 대한 조건을 반환할 때
    val c : Int = if (a != null) a.length else 0
    println(c)

    // 더 간단하게, 엘비스 연산자 (좌변이 null일 경우 우변을 반환)
    val d = a?.length ?: 0
    println(d)

}