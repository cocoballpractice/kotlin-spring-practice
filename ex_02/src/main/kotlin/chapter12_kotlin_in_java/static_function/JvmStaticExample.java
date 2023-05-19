package chapter12_kotlin_in_java.static_function;

public class JvmStaticExample {

    public static void main(String[] args) {

        // 동반 객체의 메서드 사용 시 (기본)
        String hello = HelloClass.Companion.hello();

        // 싱글톤 객체의 메서드 사용 시 (기본)
        String hi = HiObject.INSTANCE.hi();


        // JvmStatic 사용 시
        String hello2 = HelloClass.hello();

        String hi2 = HiObject.hi();

    }

}
