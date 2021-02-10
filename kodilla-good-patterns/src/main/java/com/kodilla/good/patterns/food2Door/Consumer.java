package com.kodilla.good.patterns.food2Door;

public class Consumer {
    private String name;

    public Consumer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Consumer consumer = (Consumer) o;

        return getName().equals(consumer.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
