package chapter12_kotlin_in_java.extension;

public class ExtensionExample {

    public static void main(String[] args) {

        // 코틀린에서 작성한 확장 함수
        // "ABCD".first();
        // "ABCD".addFirst('E');

        // KotlinExtension.kt가 자바 코드로 컴파일 될 경우 자바 클래스(KotlinExtensionKt) 내부의 static 메서드로 확장 함수가 구현됨
        // 따라서 자바 클래스의 static 메서드를 사용하는 것 처럼 작성해야 함
        char first = KotlinExtensionKt.first("ABCD");
        System.out.println(first);

        String addFirst = KotlinExtensionKt.addFirst("ABCD", 'E');
        System.out.println(addFirst);

    }

}
