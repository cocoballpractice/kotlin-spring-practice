package chapter12_kotlin_in_java.static_function;

public class JvmFieldExample {

    public static void main(String[] args) {

        int id = JvmFieldClass.Companion.getId();

        String name = JvmFieldObject.INSTANCE.getName();


        // const 키워드 사용 시, 혹은 @JvmField annotation 부착 시
        int code = JvmFieldClass.CODE;

        String familyName = JvmFieldObject.FAMILY_NAME;

    }

}
