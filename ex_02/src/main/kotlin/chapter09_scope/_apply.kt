package chapter09_scope

// 수신 객체의 프로퍼티를 구성하고 결과를 그대로 반환하고 싶을 때 사용

fun main() {

    // connect()가 반환하는 Boolean을 반환하는 것이 아닌, 컨텍스트인 DatebaseClient를 반환
    val client: DatabaseClient = DatabaseClient().apply {
        url = "localhost:3306"
        username = "mysql"
        password = "1234"
        connect()
    }

    client.connect().run {
        println(this) // client.connect()의 결과를 반환환
    }
}