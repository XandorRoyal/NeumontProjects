import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ConsoleApp {
    private final int myAge = 18;
    private ArrayList<Person> personList = new ArrayList<>();
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public int getNumberInput(String message) {
        int response = -1;
        do {
            try {
                System.out.println(message);
                response = Integer.parseInt(reader.readLine());
                if (response <= -1) {
                    response = -1;
                    throw new NumberFormatException();
                }
            } catch (IOException ex) {
                System.out.println("IO Error has Occured");
            } catch (NumberFormatException ex){
                System.out.println("Please input a valid number above -1.");
            }
        } while (response == -1);
        return response;
    }

    public String getStringInput(String message){
        String response = null;
        do{
            try{
                System.out.println(message);
                response = reader.readLine();
            }catch(IOException ex){
                System.out.println("IO Error has Occured");
            }
        }while(response == null);
        return response;
    }
    void mainLoop(){
        System.out.println("My age is: "+myAge);
        boolean keepGoing = true;
        do{
            createPerson();
            String cont = getStringInput("Would you like to create another person?");
            keepGoing = cont.equalsIgnoreCase("yes");
        }while(keepGoing);
        System.out.println("Input was not \"yes\" so the loop is closing.");
    }

    void printPersons(){
        for(Person p : personList){
            String older = "";
            int personAge = p.getAge();

            if (personAge > myAge) older = "Older";
            else if (personAge == myAge) older = "Same Age";
            else older = "Younger";

            System.out.println(p+" - "+older);
        }
    }
    void createPerson(){
        String Prefix = "";
        String Name = "";
        String Suffix = "";
        int Age = -1;

        Prefix = getStringInput("Please input prefix. Or input nothing for N/A");
        Name = getStringInput("Please input your Name");
        Suffix = getStringInput("Please input suffix. Or input nothing for N/A");

        Person person = new Person(Prefix, Name, Suffix);
        System.out.println("Hello, "+person.getCompletedName());

        Age = getNumberInput("Please input age in years. (0 and above)");

        person.setAge(Age);
        personList.add(person);

        printPersons();
    }
}
