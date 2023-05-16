package chapter03_singleton

// 싱글톤 생성
object Singleton {

    val a = 1234

    fun printA() = println(a)

}

fun main() {

    println(Singleton.a)
    Singleton.printA()

}