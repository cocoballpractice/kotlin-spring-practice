package chapter07_lazy

class HelloBot {

    var greeting: String? = null

    /**
     * 불변 변수(val)에만 사용 가능
     * by lazy의 경우 초기화 시점에 1회만 동작함
     * lazy(LazyThreadSafetyMode.SYNCHRONIZED) 가 기본값, NONE 설정 시 멀티 스레드 안전성 X
     * 멀티 스레드 환경 + 동기화가 필요한 상황이 아니라면 SYNCHRONIZED가 오버헤드일 수도 있으므로 NONE을 사용해도 상관은 없음
     * 멀티 스레드 환경이지만 동기화가 필요하지 않다면 PUBLICATION을 사용해도 상관은 없음
     */
    val greeting2: String by lazy {
        println("초기화 로직 수행")
        getHello()
    }

    fun sayHello() = println(greeting)
    fun sayHelloLazy() = println(greeting2)

}

fun getHello() = "안녕하세요"

fun main() {

    val helloBot = HelloBot()

    //...
    //...

    // 지연 할당, 다만 프로퍼티를 var로 선언하였기 때문에 불안함
    helloBot.greeting = getHello()
    helloBot.sayHello()

    // 지연 할당, 프로퍼티를 val로 선언
    helloBot.sayHelloLazy() // 초기화 로직 수행 메시지 출력 O (최초 초기화 진행)
    helloBot.sayHelloLazy() // 초기화 로직 수행 메시지 출력 X

    // 멀티 스레드로 병렬 실행 (멀티 스레드 환경에서도 안전하게 동작)
    for (i in 1 .. 5) {
        Thread {
            helloBot.sayHelloLazy()
        }.start()
    }

}