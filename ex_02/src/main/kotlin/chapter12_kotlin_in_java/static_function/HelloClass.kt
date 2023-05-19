package chapter12_kotlin_in_java.static_function

// 일반 클래스
class HelloClass {

    // 동반 객체
    companion object {

        @JvmStatic
        fun hello() = "hello!"

    }

}

// 싱글톤
object HiObject {

    @JvmStatic
    fun hi() = "Hi!"

}

fun main() {

    // java의 static method와 유사

    val hello = HelloClass.hello()

    val hi = HiObject.hi()

}