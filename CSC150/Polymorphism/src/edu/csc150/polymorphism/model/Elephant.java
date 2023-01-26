/**
 * @author xmartin
 * @createdOn 1/24/2023 at 2:02 PM
 * @projectName Polymorphism
 * @packageName edu.csc150.polymorphism.model;
 */
package edu.csc150.polymorphism.model;

public class Elephant extends Animal {
    private double lengthOfTrunk;

    public double getLengthOfTrunk() {
        return lengthOfTrunk;
    }
    public void setLengthOfTrunk(double lengthOfTrunk) {
        this.lengthOfTrunk = lengthOfTrunk;
    }

    public Elephant(){
        super("Elephant",true, 100.00f);
        this.lengthOfTrunk = 10.3;
    }
    public Elephant(String name, boolean hasBones, float weight, double lengthOfTrunk){
        super(name, hasBones, weight);
        this.lengthOfTrunk = lengthOfTrunk;
    }

    @Override
    public String speak(){
        return "Bahruuuuuuhhhhaaaaa!";
    }

    @Override
    public String toString(){
        return String.format("This elephant is named: %s\nIt has bones: %s\nIt's Weight is: %s\nIt's trunk is %s long.",this.getName(), this.isHasBones(), this.getWeight(), this.getLengthOfTrunk());
    }
}
