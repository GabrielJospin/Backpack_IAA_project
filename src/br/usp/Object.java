package br.usp;

public class Object {

    private int value;
    private int weight;
    private int positionArray;

    public Object(int value, int weight, int positionArray) {
        this.value = value;
        this.weight = weight;
        this.positionArray = positionArray;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPositionArray() {
        return positionArray;
    }

    public void setPositionArray(int positionArray) {
        this.positionArray = positionArray;
    }

    @Override
    public String toString() {
        return "Object{" +
                "value=" + value +
                ", weight=" + weight +
                ", positionArray=" + positionArray +
                '}';
    }
}
