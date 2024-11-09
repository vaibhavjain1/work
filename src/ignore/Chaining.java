package ignore;

interface Logger{
    void LogMessage(int level, String message);
}

class ErrorLogger extends AbstractLogger{
    ErrorLogger(int level){
        this.level = level;
    }
}

class WarnLogger extends AbstractLogger{
    WarnLogger(int level){
        this.level = level;
    }
}

class AbstractLogger implements Logger{
    Logger nextLogger;
    int level;

    ErrorLogger errorLogger = new ErrorLogger(4);
    WarnLogger warnLogger = new WarnLogger(3);

    AbstractLogger(){
        errorLogger.nextLogger = warnLogger;
    }

    public void LogMessage(int level, String message){

    }
}

public class Chaining {

    public static void main(String[] args) {
        AbstractLogger logger = new AbstractLogger();
    }
}
