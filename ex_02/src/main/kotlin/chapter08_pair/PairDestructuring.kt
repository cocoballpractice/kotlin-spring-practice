package chapter08_pair

// 직접 만들어 본 튜플 클래스
data class Tuple(val a : Int, val b: Int)

// 튜플 클래스 활용한 함수
fun plus(tuple: Tuple) = tuple.a + tuple.b

// 코틀린에서 제공하는 페어 (튜플 개념), 불변 객체, 데이터 클래스 기반 (즉, 데이터 클래스가 제공하는 함수들을 제공)
// 페어 활용 함수
fun plus2(pair: Pair<Int, Int>) = pair.first + pair.second

fun main() {

    val plus = plus(Tuple(1,3))
    println(plus)

    val plus2 = plus2(Pair(1, 3))
    println(plus2)

    val pair = Pair("A", 1)
    val newPair = pair.copy(first = "B") // 데이터 클래스의 copy
    println(newPair)

    val second = newPair.component2() // 데이터 클래스의 componentN
    println(second)

    val list = newPair.toList() // 확장 함수, 마찬가지로 불변 리스트를 반환
    println(list)

    // 코틀린에서 제공하는 트리플 (A, B, C), 불변 객체, 데이터 클래스 기반
   val triple = Triple("A", "B", "C")
    println(triple)
    triple.first
    triple.second
    triple.third

    // 구조 분해 할당 (변수 선언 생략해도 되나 가독성 / 유지보수성 / 타입 안정성을 위해 넣는 것을 추천)
    val (a: String, b: String, c: String) = triple
    println("$a, $b, $c")

    // 리스트 역시 componentN을 가지고 있으며 (1~5, 6부터는 제공하지 않음)
    val list3: List<String> = triple.toList()
    val (a1, a2, a3) = list3
    println("$a1, $a2, $a3")

    list3.component1()
    list3.component2()
    list3.component3()

    val map = mutableMapOf("코코볼" to "개발자")
    for ( (key, value) in map) {
        println("${key}의 직업은 $value")
    }
}