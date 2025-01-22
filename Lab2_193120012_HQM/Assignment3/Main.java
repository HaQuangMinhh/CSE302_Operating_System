public class Main {


    public static void main(String[] args) {
        
        int number = 50 ;
        PrimeThread primeThread = new PrimeThread(number); 

        primeThread.run();

    }


}
