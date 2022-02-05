package model;

import exceptions.NameNullException;

import java.util.*;

public class AdultClient extends ClientSkiResort {

    private int height;
    private int weight;
    private int feetSize;
    private List<ChildClient> children;         //агрегація


    public AdultClient(String name, int height, int weight, int feetSize) {
        super(name);
        this.height = height;
        this.weight = weight;
        this.feetSize = feetSize;

    }

    @Override
    public void say() {
        System.out.println("I am an adult!!!");
    }


    public List<ChildClient> getChildren() {
        return children;
    }

    public void setChildren(ChildClient children) {
        this.children.add(children);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AdultClient that = (AdultClient) o;
        return height == that.height &&
                weight == that.weight &&
                feetSize == that.feetSize &&
                Objects.equals(children, that.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), height, weight, feetSize, children);
    }


}
