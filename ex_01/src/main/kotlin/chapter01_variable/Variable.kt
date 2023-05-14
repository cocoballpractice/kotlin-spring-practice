// 변수를 탑레벨(클래스 바깥 등)에 위치시킬 수 있음
var x = 5

fun main() {
    x+= 1 // 탑레벨에서 선언한 변수를 사용할 수 있음
    println(x)

    val a : Int = 1

    val b = 1 // 타입을 생략하더라도 컴파일러가 타입을 추론해줌

    val c : Int // 지연 할당 (타입 명시 필요)
    c = 3

    /**
     * val (value)
     * final 키워드처럼 재할당이 불가, read-only
     */

    val e : String = "Hello"
    // e = "World" // 재할당 불가

    /**
     * var (variable)
     * 가변 변수, 초기화 이후에도 값 재할당이 가능
     */

    var f : String = "Hello"
    f = "안녕"

    var g = 123
    // g = "hi" // 타입이 고정되었으므로 다른 타입의 값 재할당 불가가

}