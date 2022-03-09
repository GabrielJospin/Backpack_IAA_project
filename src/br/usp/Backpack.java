package br.usp;

import java.util.LinkedList;
import java.util.List;

public class Backpack {

    private int weight;
    private int value;
    private int elementsAmount;
    private List<Object> elements;
    private final int LIMIT_WEIGHT;

    public Backpack(int LIMIT_WEIGHT) {
        this.LIMIT_WEIGHT = LIMIT_WEIGHT;
        this.weight = 0;
        this.value = 0;
        this.elementsAmount = 0;
        this.elements = new LinkedList<>();
    }

    public boolean addObject(Object o) throws NullPointerException {
        if(o == null)
            throw new NullPointerException("Object cant be nullable");

        if(o.getWeight() + this.weight > this.LIMIT_WEIGHT)
            return false;
        this.elements.add(o);
        this.weight += o.getWeight();
        this.value += o.getValue();
        this.elementsAmount += 1;
        return true;
    }

    public int getValue() {
        return value;
    }

    public int getFreeSpace(){
        return LIMIT_WEIGHT - weight;
    }
}
