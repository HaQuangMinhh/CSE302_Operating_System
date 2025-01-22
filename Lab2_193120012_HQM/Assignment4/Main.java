public class Main {


    public static void main(String[] args) throws InterruptedException {
        
        int totalPoint = 50000 ; 
        Calculator calculator = new Calculator(totalPoint);

        calculator.start();
        calculator.join();


        double pi = 4.0 * calculator.getNumberInCircle() / totalPoint ; 
        System.out.println(pi);
    }

}