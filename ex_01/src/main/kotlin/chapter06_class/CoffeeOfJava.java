package chapter06_class;

public class CoffeeOfJava {

    private boolean isIced;

    public boolean isIced() {
        return isIced;
    }

    public void setIced(boolean iced) {
        isIced = iced;
    }
}

class Barista {

    public static void main(String[] args) {

        CoffeeOfJava coffee = new CoffeeOfJava();
        coffee.setIced(true);

        if(coffee.isIced()) { // 상태를 메서드로 표현함 (getter를 통해 상태를 가져옴)
            System.out.println("아이스 커피");
        }

    }

}
