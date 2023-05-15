package chapter06_class

// 기본 생성자에 대해 constructor를 사용할 수도 있으나 생략도 가능
//class Coffee constructor(val name:String) {
class Coffee(

    // var로 선언된 프로퍼티는 자동으로 getter / setter가 생성됨
    // val로 선언된 프로퍼티는 read-only이므로 getter만 가능
    var name: String = "",
    var price: Int = 0, // 후행 쉼표 작성 가능 -> Coffee 클래스가 이후 확장되는 등 이후에 property를 쉽게 추가할 수 있게 됨, 코드 리뷰 시에도 유용
    var iced: Boolean = false,
    ) {

    val brand: String
        get() {
            return "스타벅스" // 커스텀 getter
        }

    var quantity: Int = 0
        set(value) { // 커스텀 setter
            if (value > 0) { // 수량이 0 이상인 경우에만 할당
                //quantity = value // 프로퍼티 값 직접 할당 시 순환 참조 발생 -> StackOverflowError
                field = value // field는 식별자이며 getter, setter에 대해 field 식별자를 사용, 실제 필드 참조에 접근 -> backing field에 접근

                /**
                 * backing field를 사용하는 이유 : 프로퍼티 값을 직접 할당할 경우 순환 참조가 발생함
                 * 코틀린의 프로퍼티는 객체 지향적. 프로퍼티를 메서드로 표현하지 않고 프로퍼티로서 직접 표현
                 */
            }
        }

}

// 본문 내용이 생략된 클래스도 작성 가능
class EmptyClass

fun main() {
    val coffee = Coffee()
    coffee.name = "아이스 아메리카노" // 실제로는 코틀린 컴파일러가 setter로 프로퍼티에 값 할당하여 처리
    coffee.price = 2000 // 실제로는 코틀린 컴파일러가 해당 코드를 setter로 프로퍼티에 값 할당하여 처리
    coffee.quantity = 1 // 실제로는 코틀린 컴파일러가 해당 코드를 setter(custom setter)로 프로퍼티에 값 할당하여 처리
    coffee.iced = true

    if (coffee.iced) { // 자바와 달리 상태를 메서드가 아닌 프로퍼티로 표현
        println("아이스 커피")
    }
    println("${coffee.brand} ${coffee.name} 가격은 ${coffee.price} 수량은 ${coffee.quantity}") // 실제로는 코틀린 컴파일러가 getter로 가져옴
}