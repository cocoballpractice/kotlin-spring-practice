package chapter12_kotlin_in_java.lombok;

@EqualsAndHashCode
@ToString
public class Hero {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int age;

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {

        Hero hero = new Hero();
        hero.setName("cocoball");
        hero.setAge(30);
        hero.setAddress("비밀");

    }
}
