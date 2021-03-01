package com.kodilla.testing.training;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> shapeCollection = new ArrayList<>();


    public ShapeCollector() {

    }

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
        if(shapeCollection.size()>=0){
            return shapeCollection.get(n);
        }
        else{
            return null;
        }
    }
    public void showFigure(){
        System.out.println(shapeCollection.toString());
    }
}
