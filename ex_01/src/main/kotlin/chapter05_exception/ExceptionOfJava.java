package chapter05_exception;

public class ExceptionOfJava {

    public static void main(String[] args) {

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            // 예외 처리
        }
    }

}
