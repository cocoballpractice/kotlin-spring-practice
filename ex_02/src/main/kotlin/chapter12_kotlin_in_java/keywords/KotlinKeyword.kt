package chapter12_kotlin_in_java.keywords

enum class CountryCodeKotlin {
    kr, jp, us, `do`; // do의 경우 do-while 문의 키워드(예약어) 이므로 컴파일 에러가 발생
}

fun main() {

    val javaKeyword = JavaKeyword()
    // javaKeyword.is -> is, in의 경우 코틀린의 키워드(예약어) 이므로 컴파일 에러가 발생
    javaKeyword.`is` // 예약어의 경우 백틱(``) 으로 접근 가능
    javaKeyword.`in` // 예약어의 경우 백틱(``) 으로 접근 가능

}