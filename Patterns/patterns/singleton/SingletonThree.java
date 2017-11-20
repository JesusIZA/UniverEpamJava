package patterns.singleton;

public class SingletonThree {
    private SingletonThree() {}

    private static class  SingletonHolder {
        private final static SingletonThree instance = new SingletonThree();
    }

    public static SingletonThree getInstance() {
        return SingletonHolder.instance;
    }
}
