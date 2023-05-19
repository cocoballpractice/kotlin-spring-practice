package chapter12_kotlin_in_java.lombok

fun main() {

    val hero = Hero()

    hero.name = "cocoball"
    println(hero.name) // 컴파일러 상에서는 문제가 없으나 실행 시 오류 발생

    hero.address = "비밀"
    println(hero.address)

}