package chapter03_singleton;

// 지연 초기화
public class SingletonOfJavaLazy {

    private SingletonOfJavaLazy() {}

    public SingletonOfJavaLazy getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final SingletonOfJavaLazy INSTANCE = new SingletonOfJavaLazy();
    }

}
