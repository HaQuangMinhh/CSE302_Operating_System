import java.util.List;

public class Minimum implements Runnable {

    private List<Integer> numbers ; 
    private double minimum ;
    
    public Minimum(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        minimum = numbers.get(0) ;
        
        for ( var num : numbers ) {
            if ( num < minimum ) {
                minimum = num ; 
            }
        }
    }

    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    } 
    
    
}
