

public class Facade_pattern {
    
    /** 
     * We are going to create a Shape interface and concrete classes implementing the Shape interface. 
     * A facade class ShapeMaker is defined as a next step.
     * 
     * FACADE PATTERN USES A PARENT CLASS WHICH HOLDS INSTANCES OF ALL SUBCLASSES
     * AND EXPOSES METHODS SPECIFIC TO INDIVIDUAL CLASSES WHILE HANDLING MAPPING INTERNALLY
     * 
     * 
    */

    // Create an interface.
    // Shape.java
    interface Shape {
        void draw();
    }
    
    // Step 2
    // Create concrete classes implementing the same interface.

    // Rectangle.java
    class Rectangle implements Shape {

    @Override
        public void draw() {
            System.out.println("Rectangle::draw()");
        }
    }
    // Square.java

    class Square implements Shape {

        @Override
        public void draw() {
            System.out.println("Square::draw()");
        }
    }

    // Circle.java
    class Circle implements Shape {

        @Override
        public void draw() {
            System.out.println("Circle::draw()");
        }
    }

    // Step 3 : Create a facade class.

    // ShapeMaker.java
    class ShapeMaker {
        private Shape circle;
        private Shape rectangle;
        private Shape square;

        public ShapeMaker() {
            circle = new Circle();
            rectangle = new Rectangle();
            square = new Square();
        }

        public void drawCircle(){
            circle.draw();
        }
        public void drawRectangle(){
            rectangle.draw();
        }
        public void drawSquare(){
            square.draw();
        }
    }
    // Step 4
    // Use the facade to draw various types of shapes.

    public static void main(String[] args) {

        ShapeMaker shapeMaker = new Facade_pattern().new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();		
    }
}


/**
// https://stackoverflow.com/questions/11188869/what-is-the-differences-
// between-facade-pattern-and-abstarct-factory-pattern

A facade is a class or a group of classes hiding internal implementation/services from the user.

An abstract factory encapsulates a group of factories which are used for creating objects, 
whereas Facade can be used to provide abstraction to all kinds of operations, not just creation

here we are going one level up in terms of abstraction, 
in factory shape classes were returned and draw was called on each

here ea ch method is a functionality draw is called on the runner instance, 
it determines which class to instantiate based on the param and calls the method too.

*/