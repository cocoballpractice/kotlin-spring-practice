package chapter09_scope

// 부수 작업을 하거나 전달 받은 수신 객체를 그대로 결과로 반환하고 싶을 때 사용
class User(val name: String, val password: String) {

    fun validate() {
        if (name.isNotEmpty() && password.isNotEmpty()) {
            println("검증 성공")
        } else {
            println("검증 실패")
        }
    }

    fun printName() = println(name)

}

fun main() {

    // also 미사용 시
    val user: User = User(name="tony", password="1234")
    user.validate()
    user.printName()

    // also 사용 시
    User(name="toto", password="1234").also {
        it.validate()
        it.printName()
    }

}