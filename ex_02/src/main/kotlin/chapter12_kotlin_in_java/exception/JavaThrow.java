package chapter12_kotlin_in_java.exception;

import java.io.IOException;

public class JavaThrow {

    public void throwIOException() throws IOException {
        throw new IOException("체크드 익셉션인 IOException 발생");
    }

    public static void main(String[] args) {

        JavaThrow javaThrow = new JavaThrow();

        try {
            javaThrow.throwIOException();
        } catch (IOException e) {
            e.printStackTrace();
        }

        KotlinThrow kotlinThrow = new KotlinThrow();

        // 코틀린으로 작성한 코드의 예외 처리는 try-catch로 감싸지 않아도 된다.
        // 코틀린으로 작성한 코드에서는 예외를 전파하지 않기 때문에 try-catch로 감쌀 경우 컴파일 오류 발생
        // 예외 전파가 필요하다면 코틀린 코드에서 @Throws 어노테이션 작성 필요
        kotlinThrow.throwIOException();

    }

}
