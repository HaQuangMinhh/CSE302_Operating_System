import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {


    public static void main(String[] args) throws InterruptedException {
        OldBridge ob = new OldBridge();
        Random rd = new Random(); 
        List<Thread> threads = new ArrayList<>(); 

        for ( int i = 0 ; i < 10 ; i++ ) {   // 10 chiếc xe
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        int dir = rd.nextInt(2); // Chỉ nhận 0 và 1 

                        System.out.println("Car " + Thread.currentThread().getName() + " ARRIVED, direction: " + dir);
                        ob.arrive(dir % 2); // vượt qua arrive là lên cầu 
                        System.out.println("Car " + Thread.currentThread().getName() + " is ON the bridge, direction: " + dir);

                        // on the bridge 
                        Thread.sleep(10);
                        ob.exit(dir % 2) ; 
                        System.out.println("Car " + Thread.currentThread().getName() + " has EXITED the bridge, direction: " + dir);

                    } catch (InterruptedException e) {
                        
                        e.printStackTrace();
                    }
                }
                
            }, "Car-" + i);
            threads.add(t);
            t.start();
            
        }

        for ( Thread t : threads ) {
            t.join();
        }

        System.out.println("All cars have crossed the bridge.");
    }

}
