package chapter02_data

// Java에서 직접 구현해야하거나 @Data 어노테이션으로 자동완성하던 것들(toString, equals, hashcode) 을 컴파일러가 자동으로 만들어줌
data class Person(val name: String, val age: Int)

fun main() {

    val person1 = Person(name = "tony", age = 12)
    val person2 = Person(name = "tony", age = 12)

    println(person1 == person2)

    val set = hashSetOf(person1)
    println(set.contains(person1)) // true

    val person3 = person1.copy(name="strange") // 원본의 property를 변경하여 복사(새 불변 객체 생성)
    println(person3)

    // componentN : N은 프로퍼티 개수와 동일이며 N번째의 프로퍼티를 가져옴
    println("이름=${person1.component1()}, 나이=${person1.component2()}")

    // 구조 분해 할당
    val (name, age) = person1
    println("이름=${name}, 나이=${age}")

}