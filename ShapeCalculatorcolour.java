class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    double calculateArea() {
        return 0;
    }

    public String getColor() {
        return color;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double length, double width, String color) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}

class Triangle extends Shape {
    private double base, height;

    public Triangle(double base, double height, String color) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}

public class ShapeCalculatorcolour {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5, "Red");
        shapes[1] = new Rectangle(4, 6, "Blue");
        shapes[2] = new Triangle(3, 8, "Green");

        for (Shape shape : shapes) {
            System.out.println("Shape Color: " + shape.getColor() + ", Area: " + shape.calculateArea());
        }
    }
}