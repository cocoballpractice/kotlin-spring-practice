package chapter09_enums

// class이기 때문에 생성자, 프로퍼티 선언 가능
enum class PaymentStatus(val label: String) : Payable {
    UNPAID("미지급") {
        override fun isPayable(): Boolean = true
    },
    PAID("지급 완료") {
        override fun isPayable(): Boolean = false
    },
    FAILED("지급 실패") {
        override fun isPayable(): Boolean = false
    },
    REFUNDED("환불") {
        override fun isPayable(): Boolean = false
    };
}

interface Payable {
    fun isPayable(): Boolean
}

fun main() {

    if (PaymentStatus.UNPAID.isPayable()) {
        println("결제 가능 상태")
    }

    val paymentStatus = PaymentStatus.valueOf("PAID") // PaymentStatus의 PAID 상수를 인스턴스화
    println(paymentStatus.label)

    // 동등성 비교
    if (paymentStatus == PaymentStatus.PAID) {
        println("결제 완료 상태")
    }

    // enum class의 values() 함수 : enum class 내에 선언된 상수 리스트를 반환
    for (status in PaymentStatus.values()) {
        println("${status} ${status.label}")
        println("${status.name}, ${status.ordinal}") // enum class의 values()로 반환된 리스트 내의 객체는 name(상수의 이름), ordinal(순서) 함수 사용 가능
    }
}