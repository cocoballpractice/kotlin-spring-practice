package chapter12_kotlin_in_java.getter_setter

fun main() {

    // 자바 스타일
    val person = Person()
    person.setName("지오")
    person.setAge(25)
    person.setAddress("비밀")

    println(person.getName())
    println(person.getAge())


    // 코틀린 스타일
    val person2 = Person()
    person2.name = "코코볼"
    person2.age = 30

    println(person2.name)
    println(person2.age)

    // 프로퍼티가 없음에도 게터 메서드라면 프로퍼티 처럼 사용 가능
    println(person2.uuid)

    // 세터가 있음에도 컴파일 오류가 발생
    // person2.address = "외안되"

    // address를 가져오는 메서드를 게터가 아닌 my로 했기 때문에 게터도 생성되지 않음
    // person2.address
}