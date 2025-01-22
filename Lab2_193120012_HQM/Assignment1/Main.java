

public class Main {
    public static void main(String[] args) {
        
        Data sharedData = new Data(); 

        IncrementThread t1 = new IncrementThread(sharedData);
        DecrementThread t2 = new DecrementThread(sharedData);

        try {
            t1.start();
            t1.join();

            t2.start();
            t2.join();

            System.out.println( "Final value: " + sharedData.getValue() );

        } catch (InterruptedException e ) {
            System.out.println("Error r kia " + e);
        }

    }


}
