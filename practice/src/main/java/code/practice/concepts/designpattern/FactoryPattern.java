package code.practice.concepts.designpattern;

//Step 1: Create a interface
interface Shape{
    void draw();
}

//step 2: Create a concrete class Implementing same interface
class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("drawing circles");
    }
}

class Rectangle implements  Shape{

    @Override
    public void draw() {
        System.out.println("drawing rectangle");
    }
}

//Step 3: Create a factory to create object on given information
class ShapeFactory{
    public Shape getShape(String shapeType){
        if(shapeType == null)
            return  null;
        if(shapeType.equalsIgnoreCase("circle"))
            return new Circle();
        else if (shapeType.equalsIgnoreCase("rectangle"))
            return new Rectangle();

        return  null;
    }
}

//Step 4: use Factory to create object
public class FactoryPattern {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("circle");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();
    }
}
