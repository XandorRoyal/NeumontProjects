/**
 * @author xmartin
 * @createdOn 1/23/2023 at 10:45 AM
 * @projectName Polymorphism
 * @packageName edu.csc150.polymorphism.model;
 */
package edu.csc150.polymorphism.model;

abstract public class Animal {
    private String name;
    private boolean hasBones;
    private float weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasBones() {
        return hasBones;
    }

    public void setHasBones(boolean hasBones) {
        this.hasBones = hasBones;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    abstract String speak();

    public Animal(){
        this("Unknown", true, 10.0f);
    }
    public Animal(String name, boolean hasBones, float Weight){
        setName(name);
        setHasBones(hasBones);
        setWeight(Weight);
    }

    @Override
    public String toString(){
        return String.format("This animal is named: %s\nIt has bones: %s\nThis animal has a weight of: %s",this.getName(),this.isHasBones(), this.getWeight());
    }
}
