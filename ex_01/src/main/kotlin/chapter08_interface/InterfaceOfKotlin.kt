package chapter08_interface

class Product(val name: String, val price: Int)

interface Wheel {
    fun roll()
}

interface Cart : Wheel {

    // 코틀린에서는 인터페이스 내에 추상 프로퍼티도 추가할 수 있음
    var coin: Int

    // 추상 프로퍼티
    val weight: String
        get() = "20KG" // 인터페이스는 초기값이 없기 때문에 backing field 접근이 불가

   // 추상 함수
    fun add(product: Product)

    // 디폴트 함수
    fun rent () {
        if (coin > 0) {
            println("카트를 대여합니다")
        }
    }

    // 상위 인터페이스의 추상 함수 구현
    override fun roll() {
        println("카트가 굴러가유")
    }

    /**
     * 구현 클래스가 구현하고 있는 또 다른 인터페이스와 동일한 Signature를 가진 디폴트 함수가 있을 경우
     * 컴파일 에러가 발생하며 이 경우 하위 클래스에서 override를 해야 함
     */
    fun printId() = println("카트 ID : 1234")

}

interface Order {

    // Cart 인터페이스의 함수명과 동일
    fun add(product: Product) {
        println("${product.name} 주문이 완료되었습니다")
    }

    /**
     * 구현 클래스가 구현하고 있는 또 다른 인터페이스와 동일한 Signature를 가진 디폴트 함수가 있을 경우
     * 컴파일 에러가 발생하며 이 경우 하위 클래스에서 override를 해야 함
     */
    fun printId() = println("주문 ID : 5678")

}

// 구현 클래스
class MyCart(override var coin: Int) : Cart, Order {

    override fun add(product: Product) {
        if (coin <= 0) println("코인을 넣어주세요")
        else println("${product.name}이(가) 카트에 추가되었습니다.")

        // Order의 add
        // super<상위 인터페이스> 로 상위 인터페이스에 접근이 가능
        super<Order>.add(product)
    }

    /**
     * 구현 클래스가 구현하고 있는 또 다른 인터페이스와 동일한 Signature를 가진 디폴트 함수가 있을 경우
     * 컴파일 에러가 발생하며 이 경우 하위 클래스에서 override를 해야 함
     */
    override fun printId() {
        super<Cart>.printId()
        super<Order>.printId()
    }

}

fun main() {
    val cart = MyCart(coin = 100)
    cart.rent()
    cart.add(Product(name="장난감", price = 1000))
    cart.roll()
    cart.printId()
}