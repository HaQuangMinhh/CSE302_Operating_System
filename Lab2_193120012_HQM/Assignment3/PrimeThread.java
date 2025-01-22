public class PrimeThread extends Thread {

    private int maxNumber ; 

    public PrimeThread ( int maxNumber ) {
        this.maxNumber = maxNumber ; 
    }

    public boolean isPrime (int number )  {

        if ( number < 2 ) {
            return false ; 
        }

        for ( int i = 2 ; i < Math.sqrt(number) ; i++ ) {
            if ( number % i == 0 ) {
                return false ;
            }
        }
        return true ; 
    }

    @Override
    public void run() {
        System.out.println("Prime number: " + maxNumber);

        for ( int i = 2 ; i <= maxNumber ; i++ ) {
            if ( isPrime(i) ) {
                System.out.print(i + " ");
            }
        }
        System.out.println("Completed");
    }

    


}
