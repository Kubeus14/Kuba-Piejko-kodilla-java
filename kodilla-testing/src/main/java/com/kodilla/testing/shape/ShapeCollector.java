package com.kodilla.testing.shape;
import java.util.ArrayList;
import java.util.List;


interface Shape {

    String getShapeName();
    double getField();
}
class Triangle implements Shape {
    private final static String name = "Triangle";
    private double edgeLengthA;
    private double edgeLengthB;
    private double edgeLengthC;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.edgeLengthA, edgeLengthA) != 0) return false;
        if (Double.compare(triangle.edgeLengthB, edgeLengthB) != 0) return false;
        return Double.compare(triangle.edgeLengthC, edgeLengthC) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(edgeLengthA);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(edgeLengthB);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(edgeLengthC);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Triangle(double edgeLengthA, double edgeLengthB, double edgeLengthC) {

        this.edgeLengthA = edgeLengthA;
        this.edgeLengthB = edgeLengthB;
        this.edgeLengthC = edgeLengthC;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        if(checkTriangleCondition()){
            double halfOfCircuit = getHalfOfCircuit();
            return heronsPattern(halfOfCircuit);
        } else {
            return 0;
        }
    }

    private boolean checkTriangleCondition(){
        return(edgeLengthA + edgeLengthB > edgeLengthC &&
                edgeLengthA + edgeLengthC > edgeLengthB &&
                edgeLengthB + edgeLengthC > edgeLengthA);
    }

    private double getHalfOfCircuit(){
        return (edgeLengthA + edgeLengthB + edgeLengthC)/2;
    }

    private double heronsPattern(double halfOfCircuit) {
        return Math.sqrt(halfOfCircuit*(halfOfCircuit-edgeLengthA)*(halfOfCircuit-edgeLengthB)*(halfOfCircuit-edgeLengthC));
    }
}
class Circle implements Shape{
    private final static String name = "Circle";
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(radius);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return Math.PI * Math.pow(radius, 2);
    }
}
class Square implements Shape{
    private final static String name = "Square";
    private double edgeLength;

    public Square(double edgeLength) {
        this.edgeLength = edgeLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return Double.compare(square.edgeLength, edgeLength) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(edgeLength);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return Math.pow(edgeLength, 2);
    }
}
public class ShapeCollector {
    private List<Shape> shapeCollection = new ArrayList<>();

    public List<Shape> getShapeCollection() {
        return shapeCollection;
    }

    public void addFigure(Shape shape){
        shapeCollection.add(shape);
    }

    public boolean removeFigure(Shape shape){
        return shapeCollection.remove(shape);
    }

    public Shape getFigure(int n){
        if(n<shapeCollection.size() && n>=0){
            return shapeCollection.get(n);
        } else {
            return null;
        }

    }

    public void showFigures(){
        System.out.println(shapeCollection.toString());
    }
}
