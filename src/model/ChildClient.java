package model;

import exceptions.NameNullException;

import java.util.*;

public class ChildClient extends ClientSkiResort {

    private int height;
    private int weight;
    private int feetSize;
    private AdultClient parent;         //композиція



    public ChildClient(String name, int height, int weight, int feetSize, AdultClient parent) {
        super(name);
        this.height = height;
        this.weight = weight;
        this.feetSize = feetSize;
        this.parent = parent;
    }

    @Override
    public void say() {
        System.out.println("I am a child!!!!");
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getFeetSize() {
        return feetSize;
    }

    public void setFeetSize(int feetSize) {
        this.feetSize = feetSize;
    }

    public AdultClient getParent() {
        return this.parent;
    }

    public void setParent(AdultClient parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ChildClient that = (ChildClient) o;
        return height == that.height &&
                weight == that.weight &&
                feetSize == that.feetSize &&
                Objects.equals(parent, that.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), height, weight, feetSize, parent);
    }


}