public class MainB {


    public static void main(String[] args) {
        
        Data sharedData = new Data(); 

        Thread increment = new Thread( new IncrementRunnable(sharedData));
        Thread decrement = new Thread( new DecrementRunnable(sharedData) );

    
        try {
            increment.start();
            decrement.start();
            
            increment.join();
            decrement.join();

            System.out.println("Final Value: " + sharedData.getValue());
        } catch ( InterruptedException e  ) {
            System.out.println("Error r kia " + e);
        }

    }


}
