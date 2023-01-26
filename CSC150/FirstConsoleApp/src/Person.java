import java.util.Objects;

public class Person {
    private String Name;
    private String Prefix;
    private String Suffix;
    private int Age = -1;

    public void setAge(int age){
        this.Age = age;
    }

    public int getAge(){
        return this.Age;
    }

    public String getCompletedName() {
        String newPrefix = "";
        String newSuffix = "";

        newPrefix = !this.Prefix.equals("") ? this.Prefix + " " : "";
        newSuffix = !this.Suffix.equals("") ? " " + this.Suffix : "";

        return newPrefix + this.Name + newSuffix;
    }

    @Override
    public String toString(){
        if (this.Age==-1) return this.getCompletedName();
        return this.getCompletedName()+"("+this.Age+")";
    }

    Person(String prefix, String name, String suffix){
        this.Prefix = prefix;
        this.Name = name;
        this.Suffix = suffix;
    }
}
