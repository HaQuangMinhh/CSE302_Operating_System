import java.util.ArrayList;
import java.util.List;

public class Fibonanci extends Thread {

    private int n ; 
    private List<Integer> fibonancci ;
    
    public List<Integer> getFibonancci() {
        return fibonancci;
    }

    public Fibonanci ( int n ) {
        this.n = n ;
        this.fibonancci = new ArrayList<>(); 
    }

    @Override
    public void run() {
        if ( n > 0 ) {
            fibonancci.add(0); 
        }

        if ( n > 1 ) {
            fibonancci.add(1);
        }

        for ( int i = 2 ; i < n ; i++  ) {
            var next = fibonancci.get(i - 1) + fibonancci.get(i -2);
            fibonancci.add(next); 
        }
    }

    

}
