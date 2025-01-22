import java.util.List;

public class Main {



    public static void main(String[] args) throws InterruptedException {
        int n = 10 ;

        Fibonanci fibonanciThread = new Fibonanci(n);

        fibonanciThread.start(); // bat dau tinh chuoi

        fibonanciThread.join();
        
        List<Integer> result = fibonanciThread.getFibonancci();

        System.out.println("Fibonanci: ");
        for ( var each : result ) {
            System.out.print( each + " ");
        }

    }

    
}
