package chapter12_kotlin_in_java.getter_setter

import java.time.LocalDate

class Student {

    @JvmField // java에서 접근 시 kotlin 처럼 getter / setter가 아닌 프로퍼티 접근이 가능해짐
    var name: String? = null

    var birthDate: LocalDate? = null

    val age: Int = 10

    var grade: String? = null
        private set // setter 외부 사용을 막음

    fun changeGrade(grade:String) {
        this.grade = grade
    }

}