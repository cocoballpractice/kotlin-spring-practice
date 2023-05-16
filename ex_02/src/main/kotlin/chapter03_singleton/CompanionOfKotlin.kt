package chapter03_singleton

class MyClass {

    // MyClass의 생성자를 private 처리
    private constructor()

    // 동반 객체 : 클래스 내부에서 생성되는 객체
    companion object MyCompanion {
        val a = 1234

        fun newInstance() = MyClass()
    }

}

fun main() {

    // 동반 객체의 필드, 함수를 사용
    println(MyClass.a)
    println(MyClass.newInstance())

    // 동반 객체의 이름으로 호출 가능
    // 단, 이름을 짓지 않는 경우가 더 많음음
    println(MyClass.MyCompanion.a)
    println(MyClass.MyCompanion.newInstance())

}