package designPatterns;

//Usage: java.lang.Runtime, java.awt.Desktop, java.lang.System.
public class Singleton {
    private volatile static Singleton single;

    private Singleton(){
        // Not allowed
    }

    public static Singleton getInstance(){
        if(single == null) {
            synchronized(Singleton.class){
                if(single == null) {
                    single = new Singleton();
                }
            }
        }
        return single;
    }
}
