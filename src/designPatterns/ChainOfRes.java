package designPatterns;
enum LoggerLevel {
    debug(1),
    info(2),
    warn(3),
    error(4);
    LoggerLevel(int level){
        this.level = level;
    }
    int level;
}

interface Chain {
    void print(LoggerLevel level, String message);
}

class Logger implements Chain {

    @Override
    public void print(LoggerLevel level, String message) {

    }
}

class ErrorLogger implements Chain {
    @Override
    public void print(LoggerLevel level, String message) {
        System.out.println("Printing error: "+ message);
    }
}

class WarnLogger extends ErrorLogger{
    int warnLevel = 3;

    @Override
    public void print(LoggerLevel level, String message) {
        if(level.level == warnLevel)
            System.out.println("Printing warning: "+ message);
        else
            super.print(level, message);
    }
}

public class ChainOfRes {
    public static void main(String[] args) {

    }
}
