package chapter03_singleton;

// 이른 초기화
public class SingletonOfJavaEager {

    private static final SingletonOfJavaEager INSTANCE = new SingletonOfJavaEager();

    private SingletonOfJavaEager() {}

    public SingletonOfJavaEager getInstance() {
        return INSTANCE.INSTANCE;
    }

}
