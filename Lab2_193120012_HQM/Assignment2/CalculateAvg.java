import java.util.List;

public class CalculateAvg implements Runnable {

    private List<Integer> numbers ; 
    private double average ; 
    
    public CalculateAvg ( List<Integer> numbers ) {
        this.numbers = numbers ; 
    }

    @Override
    public void run() {
        double sum = 0 ; 
        for  ( var number : numbers  ) {
            sum += number ; 
        }
        this.average = sum / numbers.size() ; 
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

}
