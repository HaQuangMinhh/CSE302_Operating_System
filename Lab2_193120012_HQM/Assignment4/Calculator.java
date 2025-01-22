import java.util.Random;

public class Calculator extends Thread {

    private int totalPoint  ; 
    private int numberInCircle = 0 ; 

    public Calculator ( int totalPoint ) {
        this.totalPoint = totalPoint ; 
    }

    public int getNumberInCircle() {
        return numberInCircle;
    }

    @Override
    public void run() {
        Random rd = new Random() ; 

        for ( int i = 0 ; i < totalPoint ; i++ ) {
            double x = rd.nextInt(); 
            double y = rd.nextInt(); 

            if ( x * x + y * y <= 1 ) {
                numberInCircle++ ; 
            }
        }
    }
}
