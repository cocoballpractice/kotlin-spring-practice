package chapter03_singleton

import java.time.LocalDateTime

// 싱글톤을 활용한 유틸리티 클래스
object DatetimeUtils {

    val now : LocalDateTime
        get() = LocalDateTime.now()

    // Java의 상수 개념
    const val DEFAULT_FORMAT = "YYYY-MM-DD"

    fun same(a: LocalDateTime, b: LocalDateTime) : Boolean {
        return a == b
    }

}

fun main() {

    println(DatetimeUtils.now)
    println(DatetimeUtils.now)
    println(DatetimeUtils.now)

    println(DatetimeUtils.DEFAULT_FORMAT)

    val now = LocalDateTime.now()
    println(DatetimeUtils.same(now, now))

}