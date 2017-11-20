package patterns.singleton;

public class SingletonOne {
    private static SingletonOne instance;

    private SingletonOne() {}

    public static SingletonOne getInstance() {
        if (instance == null)
            instance = new SingletonOne();
        return instance;
    }
}
