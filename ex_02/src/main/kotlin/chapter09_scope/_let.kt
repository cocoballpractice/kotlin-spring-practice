package chapter09_scope

fun main() {

    // null이 아닌 경우 사용될 로직을 작성, 그에 대한 결과를 반환하고 싶을 때 사용

    val str: String? = "헬로"

    val result: Int? = str?.let {
        println(it) // str이 null이 아닐 경우에 작동

        val abc: String? = "abc"
        val def: String? = "def"
        if (!abc.isNullOrEmpty() && !def.isNullOrEmpty()) {
            println("abcdef가 null이 아님")
        }
        1234 // return 생략
    }
    println(result)

}