package chapter12_kotlin_in_java.static_function

class JvmFieldClass {

    companion object {

        val id = 1234

        const val CODE = 1234
    }

}

object JvmFieldObject {

    val name = "cocoball"

    const val FAMILY_NAME = "hwang"

}

fun main() {

    val id = JvmFieldClass.id

    val name = JvmFieldObject.name

}