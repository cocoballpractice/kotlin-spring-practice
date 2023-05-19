package chapter12_kotlin_in_java.exception

import java.io.IOException

class KotlinThrow {

    //@kotlin.jvm.Throws(IOException::class) -> 자바와 상호 운용 시 try-catch를 위해 예외 전파가 필요할 경우 사용
    fun throwIOException() {
        throw IOException("체크드 익셉션인 IOException 발생")
    }

}

fun main() {

    // java, kotlin 동일하게 예외 처리 강제하지 않음

    val javaThrow = JavaThrow()
    javaThrow.throwIOException()

    val kotlinThrow = KotlinThrow()
    kotlinThrow.throwIOException()

}