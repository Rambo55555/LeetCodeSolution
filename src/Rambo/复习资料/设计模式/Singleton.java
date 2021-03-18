package Rambo.复习资料.设计模式;

public class Singleton {
    private static volatile Singleton singleton;
    private Singleton(){}
    public static Singleton getSingleton(){

        if(singleton == null) {
            synchronized(Singleton.class) {
                if(singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
