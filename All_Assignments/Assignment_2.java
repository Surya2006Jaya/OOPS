import java.util.ArrayList;
import java.util.List;

class Person implements Cloneable {
    String name;
    List<String> hobbies;
    

    public Person(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = hobbies;
    }

    // Shallow clone: only top-level fields are copied
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // hobbies list is shared!
    }

    public void addHobby(String hobby) {
        hobbies.add(hobby);
        System.out.println("JAYA SURYA S");
    	System.out.println("2117240070126");
    	System.out.println("");
    }

    public void printDetails(String label) {
    	
        System.out.println(label + " -> Name: " + name + ", Hobbies: " + hobbies);
    }
}

public class Shollow{
    public static void main(String[] args) throws CloneNotSupportedException {
        List<String> hobbyList = new ArrayList<>();
        hobbyList.add("Reading");
        hobbyList.add("Cycling");

        Person original = new Person("Jaya", hobbyList);
        Person clone = (Person) original.clone(); // shallow clone

        // Modify the clone's list
        clone.addHobby("Gaming");

        // Print both objects
        original.printDetails("Original");
        clone.printDetails("Clone");
    }
}
