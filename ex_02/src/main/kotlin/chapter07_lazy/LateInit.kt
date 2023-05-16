package chapter07_lazy

/**
 * lateinit 키워드 : 가변 변수에 대한 지연 초기화
 * DI(Spring Framework 등), 외부에서의 초기화를 염두해두고 만들어짐
 */

class LateInit {

    lateinit var text: String // 안전 연산자 사용 시 컴파일 에러. 가변 변수에 대한 지연 초기화를 한다면 NonNull 타입이어야 함

    // 외부로 isInitialized 노출하기 위한 프로퍼티티
   val textInitialized: Boolean
        get() = this::text.isInitialized

    fun printText() {
        // isInitialized 로 초기화 여부 확인 가능, 단 클래스 내부에서만 사용 가능, 외부에선 사용 불가
        if (this::text.isInitialized) {
            println("초기화됨")
        } else {
            text = "안녕하세요"
        }
        println(text)
    }

}

fun main() {

    val test = LateInit()
    test.printText()
    test.textInitialized // 외부로 노출

}