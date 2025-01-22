import java.util.List;

public class Maximum implements Runnable {

    private List<Integer> numbers ; 
    private double maximum ;
    public Maximum(List<Integer> numbers) {
        this.numbers = numbers;
    }
    public double getMaximum() {
        return maximum;
    }
    public void setMaximum(double maximum) {
        this.maximum = maximum;
    }
    @Override
    public void run() {
        maximum = numbers.get(0); 

        for ( var num : numbers ) {
            if ( num > maximum ) {
                maximum = num ; 
            }
        }
        
    }
    
    

}
