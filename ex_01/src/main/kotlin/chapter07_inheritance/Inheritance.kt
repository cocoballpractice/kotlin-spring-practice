package chapter07_inheritance

open class Dog {
    open var age : Int = 0

    open fun bark() {
        println("멍멍")
    }
}

// Dog 클래스 상속
// 기본 생성자를 통해서도 프로퍼티에 대해 재정의가 가능
open class Bulldog(final override var age : Int = 0) : Dog() {

    //override var age : Int = 0

    // ChildBulldog에서 재정의하지 못하게끔 final 키워드 사용
    final override fun bark() {
        println("컹컹")
    }

}

/**
 * 상속을 이미 받은 클래스의 하위 클래스 (Dog -> Bulldog -> ChildBulldog)의 경우
 * 상위 클래스가 함수, 프로퍼티에 대해 open을 하지 않더라도 재정의가 가능
 * 따라서 이를 원치 않을 경우, 하위 클래스가 재정의하지 못하게끔 final 키워드를 붙이면 됨
 * 하위 클래스에서 상위 클래스의 함수나 프로퍼티를 그대로 재사용할 경우 java와 마찬가지로 super 키워드 사용
 */
class ChildBulldog : Bulldog() {

    /*
    override var age: Int = 0
    override fun bark() {
        super.bark()
    }
     */
}

// 추상 클래스
abstract class Developer {

    abstract var age : Int
    abstract fun code(language: String)

}

// 구체 클래스
class BackendDeveloper(override var age: Int) : Developer() {

    override fun code(language: String) {
        println("$language 언어로 코딩을 한다잉")
    }
}
fun main() {
    val dog = Bulldog(age = 2)
    println(dog.age)
    dog.bark()

    val backendDeveloper = BackendDeveloper(30)
    println(backendDeveloper.age)
    backendDeveloper.code("Kotlin")

}