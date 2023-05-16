package chapter04_sealed

/**
 * 실드 클래스 : 하나의 상위 클래스 / 인터페이스에서 하위 클래스에 대한 정의를 제한할 수 있는 방법
 * 실드 클래스로 설정할 경우 컴파일러는 해당 클래스의 하위 클래스들을 인지하게 됨
 * 이 경우 when 식에서 실드 클래스의 하위 클래스들을 사용하게 되면 모든 하위 클래스들을 조건에 넣어둬야 함 (케이스를 빼먹을 수 없음)
 * else를 통해 발생할 수 있는 버그를 줄일 수 있음
 * 실드 클래스는 하위 클래스를 제한 조건을 두어야 함
 * 제한 조건 (1.6버전)
 * - 같은 패키지, 같은 모듈 안에 있는 경우에만 하위 클래스를 정의할 수 있음
 * - 현재는 많이 완화된 상태, 최근 버전 확인 필요 (이전에는 같은 파일 안에 존재해야했음)
 */
sealed class Developer {

    abstract val name: String
    abstract fun code(language: String)

}

data class BackendDeveloper(override val name: String) : Developer() {

    override fun code(language: String) {
        println("저는 백엔드 개발자입니다 ${language}를 사용해요")
    }

}

data class FrontendDeveloper(override val name: String) : Developer() {

    override fun code(language: String) {
        println("저는 프론트엔드 개발자입니다 ${language}를 사용해해요")
    }
}

object OtherDeveloper : Developer() {

    override val name: String = "익명"

    override fun code(language: String) {}
}

object DeveloperPool {

    val pool = mutableMapOf<String, Developer>()

    fun add(developer: Developer) = when(developer) {
        is BackendDeveloper -> pool[developer.name] = developer
        is FrontendDeveloper -> pool[developer.name] = developer
        is OtherDeveloper -> println("지원하지 않는 개발자 종류입니다")
        /*
        else -> { // else를 삭제할 경우 컴파일 에러 발생. 컴파일러 입장에서는 하위 클래스가 Back, Front 외에 더 있는지 없는지 확인이 불가
            println("지원하지 않는 개발자입니다")
        }
         */
    }

    fun get(name: String) = pool[name]

}

fun main() {

    val backendDeveloper = BackendDeveloper(name="코코볼")
    DeveloperPool.add(backendDeveloper)

    val frontendDeveloper = FrontendDeveloper(name="지오")
    DeveloperPool.add(frontendDeveloper)

    println(DeveloperPool.get("코코볼"))
    println(DeveloperPool.get("지오"))

}