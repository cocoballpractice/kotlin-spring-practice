package chapter12_kotlin_in_java.getter_setter;

import java.time.LocalDate;

public class JavaGetterSetterExample {

    public static void main(String[] args) {

        // 코틀린으로 작성한 Student
        Student student = new Student();

        // student.setName("코코볼");
        student.name = "코코볼"; // @JVMField annotation
        student.setBirthDate(LocalDate.of(1993, 6, 15));

        // System.out.println(student.getName());
        System.out.println(student.name);  // @JVMField annotation
        System.out.println(student.getBirthDate());

        // student.setAge(31); 컴파일 에러, 불변 객체이므로
        System.out.println(student.getAge());

        // student.setGrade(""); 컴파일 에러, setter가 막혀 있음
        System.out.println(student.getGrade());
        student.changeGrade("A");

    }

}
