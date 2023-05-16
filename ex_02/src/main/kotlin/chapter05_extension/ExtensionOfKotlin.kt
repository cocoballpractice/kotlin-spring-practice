package chapter05_extension

/**
 * 코틀린의 확장 기능 : 클래스 상속 / 데코레이터 패턴 등을 사용하지 않더라도 클래스를 확장할 수 있음
 * 확장하려는 클래스.확장하려는 함수명
 * 프로퍼티의 확장도 가능
 * 주의 사항 : 확장하려는 함수와 원본의 함수 이름, 파라미터가 같을 경우 원본의 함수가 사용됨
 * 이름이나 파라미터가 다르다면 확장 함수도 호출 가능
 */

fun String.first() : Char {
    return this[0] // this는 수신자 객체(receiver)로, 확장이 되는 객체의 참조
}

fun String.addFirst(char : Char) : String {
    return char + this.substring(0) // this는 수신자 객체(receiver)로, 확장이 되는 객체의 참조
}

class MyExample {
    fun printMessage() = println("클래스 출력")
}

fun MyExample.printMessage(message : String) = println(message)

fun MyExample?.printNullOrNotNull() {
    if (this == null) println("널인 경우에만 출력")
    else println("널이 아닌 경우에만 출력")
}

fun main() {

    println("ABCD".first())
    println("ABCD".addFirst('Z'))

    MyExample().printMessage() // 클래스가 보유한 함수가 사용됨
    MyExample().printMessage("확장 출력") // 확장 함수 사용됨

    var myExample: MyExample? = null
    myExample.printNullOrNotNull() // null인 상태, 확장 함수 레벨에서 안전 연산자를 사용하였기 때문에 호출 시 안전 연산자를 사용하지 않아도 됨

    myExample = MyExample()
    myExample.printNullOrNotNull() // null이 아닌 상태

}