package chapter10_exception;

import java.io.FileWriter;
import java.io.IOException;

public class TryWithResource {

    public static void main(String[] args) {

        try (FileWriter writer = new FileWriter("test.txt")) {
            writer.write("Hello Java");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
