package comparingstudents;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author janvit
 */
public class Datasource {
    private static Student[] data = {
      new Student("Alice", "Mala", 345, new int[]{1, 2, 3, 4, 5}),
      new Student("Bob", "Velky", 123, new int[]{2, 2, 3, 5, 4}),
      new Student("Cyril", "stredny", 567, new int[]{2, 1, 1, 1, 4})
    };
    
    public static Student[] loadDataAsArray(){
        return Arrays.copyOf(data, data.length);
    }
    
    public static List<Student> loadDataAsList(){ //List je interface, ktery implementuji ArrayList, LinkedList...
        return Arrays.asList(data);
        //ArrayList<Student> students = new ArrayList<>();
        //students.addAll(Arrays.asList(data));
    }
}
