package designPatterns;

public class Decorator {
    public static void main(String[] args) {

    }
}

interface coffee{
    void prepare();
}

class Capachino implements coffee{

    @Override
    public void prepare() {
        System.out.println("Preparing Capachino");
    }
}

class Mocha implements coffee{

    @Override
    public void prepare() {
        System.out.println("Preparing Mocha");
    }
}

class SugarDecorator{
    coffee coffee;
    SugarDecorator(coffee coffee){
        this.coffee = coffee;
    }


}