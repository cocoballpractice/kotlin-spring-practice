package chapter01_collection

import java.util.*

fun main() {

    // immutable
    val currencyList = listOf("달러", "유로", "원")

    // mutable
    //val mutableCurrencyList = mutableListOf<String>("달러, 유로, 원") --> 요것도 가능
    val mutableCurrencyList = mutableListOf<String>().apply {
        add("달러")
        add("유로")
        add("원")
    }

    // immutable set
    val numberSet = setOf(1, 2, 3, 4)

    // mutable set
    val mutableSet = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
    }

    // immutable map
    val numberMap = mapOf("one" to 1, "two" to 2) // to는 중위 표현식 key to value

    // mutable map
    val mutableMap = mutableMapOf<String, Int>()
    mutableMap.put("one", 1) // 자바 형식
    mutableMap["two"] = 2 // 코틀린 추천
    mutableMap["three"] = 3


    // 컬렉션 빌더 활용
    // buildList 내부에서는 MutableList로 값을 세팅하지만 이를 List<Int>로 immutable한 리스트를 반환
    val numberList: List<Int> = buildList {
        add(1)
        add(2)
        add(3)
    }
    // numberList.add(2) --> immutable list이므로 add 불가


    // java linkedList
    val linkedList = LinkedList<Int>().apply {
        addFirst(1)
        add(2)
        addLast(10)
    }

    // java arrayList
    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    // 순차적 반복 (자바와 마찬가지)
    val iterator = currencyList.iterator()
    while(iterator.hasNext()) {
        println(iterator.next())
    }

    println("---------------")

    // for loop를 활용한 반복
    for (currency in currencyList) {
        println(currency)
    }

    // java의 Stream API와 유사한 기능을 가진 인라인 함수들을 지원 - forEach
    currencyList.forEach {
        println(it)
    }


    // java의 Stream API와 유사한 기능을 가진 인라인 함수들을 지원 - for loop -> map
    val lowerList = listOf("a", "b", "c")

    // map을 사용하지 않을 경우
    /*
    val upperList = mutableListOf<String>()
    for (lowerCase in lowerList) {
        upperList.add(lowerCase.uppercase())
    }
     */

    // map을 사용
    val upperList = lowerList.map { it.uppercase() }

    // java의 Stream API와 유사한 기능을 가진 인라인 함수들을 지원 - filter
    // filter를 사용하지 않을 경우
    /*
    val filteredList = mutableListOf<String>()
    for (upperCase in upperList) {
        if (upperCase == "A" || upperCase == "C") {
            filteredList.add(upperCase)
        }
    }
     */

    // filter를 사용
    val filteredList = upperList.filter { it == "A" || it == "C" }


    // asSequence() API
    val sequenceList = upperList.asSequence()
        .filter { it == "A" || it == "C" }
        .toList() // Terminal Operator


}