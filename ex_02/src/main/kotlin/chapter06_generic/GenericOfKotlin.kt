package chapter06_generic

class MyGenerics<out T>(val t: T) {

}

class Bag<T> {

    fun saveAll(
        to: MutableList<in T>,
        from: MutableList<T>
    ) {
        to.addAll(from)
    }

}

fun main() {

    // 제네릭을 사용한 클래스의 인스턴스를 만드려면 타입 arg를 제공
    val generics = MyGenerics<String>("테스트")

    // 타입 추론이 가능하다면 타입 arg 생략 가능
    val generics2 = MyGenerics("테스트")

    // 변수의 타입에 제네릭을 사용한 경우
    val list1: MutableList<String> = mutableListOf()

    // 생성자에서 타입 arg를 추가한 경우
    val list2 = mutableListOf<String>()

    // star projection (*) 을 통해 타입 추론을 하지 못하더라도 안전하게 사용 가능
    val list3 : List<*> = listOf<String>("테스트")
    val list4 : List<*> = listOf<Int>(1,2,3,4)

    /**
     * 제네릭의 변성 (가장 어려운 내용)
     * 제네릭에서 파라미터화된 타입이 서로 어떤 관계에 있는지 설명하는 개념이 변성
     * 공변성, 반공변성, 무공변성 -> 이펙티브 자바 참조
     * PECS (Producer - Extends, Consumer - Super)
     * 공변성은 자바 제네릭의 extends, 코틀린에선 out
     * 반공변성은 자바 제네릭의 super, 코틀린에선 in
     */

    // 공변성, 제네릭을 제공
    val stringGenerics = MyGenerics<String>("테스트")
    val charGenerics : MyGenerics<CharSequence> = stringGenerics // 공변성, CharSequence가 String의 상위 타입

    // 반공변성, 제네릭을 사용
    val bag = Bag<String>()
    bag.saveAll(mutableListOf<CharSequence>("1", "2"), mutableListOf<String>("3", "4")) // 반공변성, String이 CharSequence의 하위 타입

}