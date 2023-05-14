package chapter05_exception

fun main() {

    Thread.sleep(1) // checked exception을 강제하지 않음 (컴파일 에러 x)

    // 필요하다면 try-catch, finally 사용도 가능
    try {
        Thread.sleep(1)
        throw Exception()
    } catch (e: Exception) {
        println("에러 발생")
    } finally {
        println("finally 실행")
    }

    // try-catch는 자바와 달리(구문) 식이기 때문에 값을 반환할 수 있음
    val a = try {
        "1234".toInt()
    } catch (e: Exception) {
        println("예외 발생")
    }
    println(a)

    // NullSafety와의 활용
    val b: String? = null
    val c = b?: failFast("a is null")

    println(c.length) // 위에서 c가 nullable하지 않음(nonnull)을 확인하였기 때문에 컴파일 에러 x

    failFast("에러 발생")
    println("이 코드는 실행될까요?")

}

// throw 역시 식이기 때문에 값을 반환할 수 있음
// 코드가 정상적으로 실행되는 것을 보장하지 못할 경우 Nothing 반환
fun failFast(message : String) : Nothing {
    throw IllegalArgumentException(message)
}