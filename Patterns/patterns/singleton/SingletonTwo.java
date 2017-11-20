package patterns.singleton;

public class SingletonTwo {
    private static SingletonTwo instance = new SingletonTwo();

    private SingletonTwo() {}

    public static SingletonTwo getInstance() {
        return instance;
    }
}
