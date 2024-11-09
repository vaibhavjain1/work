package designPatterns;

import java.util.*;


class Circle{
    String color;
}

class ProtoTypeCreator{
    Map<String, Circle> map = new HashMap<>();

    Circle circleProvider(String color){
        Circle circle = map.get(color);
        if(circle == null){
            circle = new Circle();
            circle.color = color;
            map.put(color, circle);
        }
        return circle;
    }
}

public class PrototypeDemo {

    public static void main(String[] args) {

    }
}
