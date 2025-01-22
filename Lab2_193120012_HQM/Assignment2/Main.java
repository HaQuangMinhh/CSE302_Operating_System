import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        
        List<Integer> numbers = new ArrayList<>(); 

        // Create thread 
        CalculateAvg average = new CalculateAvg(numbers);

        Minimum minimum = new Minimum(numbers); 
        Maximum maximum = new Maximum(numbers);

        Thread avg = new Thread(average) ; 
        Thread min = new Thread(minimum); 
        Thread max = new Thread(maximum); 

        // Start threads 
        



    }


}
