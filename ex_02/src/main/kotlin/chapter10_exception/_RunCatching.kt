package chapter10_exception

fun getStr(): Nothing = throw Exception("예외 발생 기본 값으로 초기화")

fun main() {

    // Run Catching 미적용

    val result = try {
        getStr()
    } catch (e: Exception) {
        println(e.message)
        "기본값"
    }

    println(result)


    // Run Catching 적용
    // getOrNull() : 성공인 경우 runCatching 내부 결과를 반환, 실패인 경우 null 반환
    // exceptionOrNull : 성공인 경우 null을 반환, 실패인 경우 throwable 반환
    // getOrDefault("기본값") : 성공은 경우 runCatching 내부 결과를 반환, 실패인 경우 기본값을 반환
    // getOrElse() : 성공인 경우 runCatching 내부 결과를 반환, 실패인 경우 내부 로직을 처리
    // getOrThrow() : 성공인 경우 runCatching 내부 결과를 반환, 실패인 경우 예외를 반환

    val result2 = runCatching { getStr() }
        .getOrElse {
            println(it.message)
            "기본값"
        }

    println(result2)


    // map
    val result3 = runCatching { "안녕" }
        .map {
            "${it}하세요"
        }.getOrThrow()

    println(result3)


    // map-catching
    val result4 = runCatching { "안녕" }
        .mapCatching {
            throw Exception("예외")
        }.getOrDefault("기본 값") // map 내부에서도 예외가 발생할 수도 있음
    // -> mapCatching 사용 시 mapCatching 내부에서 예외가 발생하더라도 그 이후에 사용하는 함수에서는 회복이 가능

    println(result4)


    // recover
    val result5 = runCatching { getStr() }
        .recover {
            "복구"
            // 비즈니스 로직...
        } // 예외 발생 시에만 작동
        .getOrNull()

    println(result5)

    // recover-catching : recover 과정에서 예외 발생하더라도 그 이후에 사용하는 함수에서는 회복이 가능능
}