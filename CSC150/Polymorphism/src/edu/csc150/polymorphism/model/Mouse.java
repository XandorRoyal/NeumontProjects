/**
 * @author xmartin
 * @createdOn 1/24/2023 at 2:03 PM
 * @projectName Polymorphism
 * @packageName edu.csc150.polymorphism.model;
 */
package edu.csc150.polymorphism.model;

public class Mouse extends Animal{
    private double lengthOfTail;

    public double getLengthOfTail() {
        return lengthOfTail;
    }

    public void setLengthOfTail(double lengthOfTail) {
        this.lengthOfTail = lengthOfTail;
    }

    public Mouse(){
        super("Jerry", true, 1.0f);
        this.lengthOfTail = 4.0;
    }

    public Mouse(String name, boolean hasBones, float weight, double lengthOfTail){
        super(name,hasBones,weight);
        this.lengthOfTail = lengthOfTail;
    }

    @Override
    public String speak(){
        return "Squeak Squeak!";
    }

    @Override
    public String toString(){
        return String.format("This elephant is named: %s\nIt has bones: %s\nIt's Weight is: %s\nIt's tail is %s long.",this.getName(), this.isHasBones(), this.getWeight(), this.getLengthOfTail());
    }
}
