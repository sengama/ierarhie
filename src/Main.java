public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(5.0), new Rectangle(4.0, 6.0), new Sphere(3.0), new Cylinder(4.0, 8.0)};
        printShapes(shapes);
    }

    private static void printShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            System.out.println("Area of " + shape.getClass().getSimpleName() + ": " + shape.calculateArea());
            if (shape instanceof ThreeDimensionalShape) {
                System.out.println("Volume of " + shape.getClass().getSimpleName() + ": " + ((ThreeDimensionalShape) shape).calculateVolume());
            }
        }
    }
}

abstract class Shape {
    abstract double calculateArea();
}

abstract class ThreeDimensionalShape extends Shape {
    abstract double calculateVolume();
}

class Circle extends Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}
class Sphere extends ThreeDimensionalShape {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }
}
class Cylinder extends ThreeDimensionalShape {
    private double radius;
    private double height;
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    @Override
    double calculateArea() {
        return 2 * Math.PI * radius * (radius + height);
    }
    @Override
    double calculateVolume() {
        return Math.PI * radius * radius * height;
    }
}
