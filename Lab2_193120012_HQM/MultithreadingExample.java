public class MultithreadingExample {


    public static void main(String[] args) {
        
        PrintHelloThread t = new PrintHelloThread();
        PrintHelloThread t2 = new PrintHelloThread() ;

        t.start();
        t2.start(); 

        try {
            t.join();
            t2.join();
        } catch ( InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main thread terminated");

    }


}
