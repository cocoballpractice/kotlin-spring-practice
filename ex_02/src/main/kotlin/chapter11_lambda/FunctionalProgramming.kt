package chapter11_lambda

// 함수를 변수로 선언, printHello2와 동일
var printHello : () -> Unit = { println("Hello") }

// fun으로 작성 시에는 일급 객체의 특성을 가질 수 없음
fun printHello2() {
   println("Hello")
}

// 함수를 인자로 받아 실행하는 함수
fun call(block: () -> Unit) {
    block()
}

// String을 받는 함수이며 반환값은 없음 (Unit), String을 받은 것을 message로 하여 println
val printMessage: (String) -> Unit = { message: String -> println(message) }

// 받는 값이 String이기 때문에 함수 부분에서 String 타입 생략
val printMessage2: (String) -> Unit = { message -> println(message) }

// 소프트 키워드인 it를 사용 (인자가 한개인 경우에만)
val printMessage3: (String) -> Unit = { println(it) }

// Int 타입 파라미터를 2개 받아서 두 파라미터를 더한 값을 반환 (Int 타입)
val plus : (Int, Int) -> Int = {a,b -> a + b}

// 고차 함수 : 함수를 인자로 받거나 결과로 돌려주는 함수
// action을 통해 함수를 인자로 받을 수 있도록 선언 (String으로 받고 반환하는 것은 없음)
fun forEachStr(collection: Collection<String>, action: (String) -> Unit) {
    for (item in collection) {
        action(item) // 함수를 실행
   }
}

// 익명 함수
fun outerFunc() : () -> Unit {
    return fun() {
        println("이것은 익명 함수")
    }
}

// 람다를 활용한 익명 함수
fun outerFunc2() : () -> Unit = { println("이것은 익명 함수") }

// 람다식 전체
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y}

// 최대한 생략
val sum2 = { x: Int, y: Int -> x + y }


fun main() {

    // 함수를 값으로 사용
    // 함수형 프로그래밍에서 함수는 일급 객체로 분류됨 -> 함수를 인자로 넘기거나 결과로 반환하거나, 값으로 취급이 가능

    val list = mutableListOf(printHello)

    list[0]() // 함수를 사용할 때엔 함수 실행 표기법으로 () 사용 필요

    val func : () -> Unit = list[0]
    func()

    call(printHello)

    val list2 = listOf("a", "b", "c")
    val printStr : (String) -> Unit = {println(it)} // 함수
    forEachStr(list2, printStr) // 컬렉션과 함수를 받아서 실행

    outerFunc()() // outerFunc() 만 할 경우 outerFunc()를 선언만 하는 것이라 ()를 한번 더 작성해줘야 함
    val oFunc = outerFunc2()
    oFunc()

    // 람다 레퍼런스 사용 전
    val callReference : () -> Unit = { printHello() }
    callReference()

    // 람다 레퍼런스 사용 시
    // 레퍼런스 사용 시 탑레벨 함수이거나 로컬에 있는 함수일 경우에는 클래스를 명시하지 않아도 되나 확장 함수나 클래스의 멤버 함수일 경우 클래스 명시 필요
    val callReference2 = ::printHello
    callReference2()

    val numberList = listOf("1", "2", "3")
    // numberList.map { it.toInt() }.forEach{ println(it) }
    numberList.map(String::toInt).forEach(::println)

    // 코틀린에서 arrow라는 함수형 라이브러리를 사용할 경우 함수형 프로그래밍을 쉽게 적용할 수 있음 (함수형 프로그래밍에서 자주 사용하는 것들 등)
}