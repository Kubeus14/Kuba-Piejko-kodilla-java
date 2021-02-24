package com.kodilla.patterns.prototype.library;

public class Prototype<C> implements Cloneable {
    @Override
    public C clone () throws CloneNotSupportedException{
        return (C)super.clone();
    }
}
