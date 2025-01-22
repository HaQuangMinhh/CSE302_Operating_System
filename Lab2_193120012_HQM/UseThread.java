public class UseThread {


    public static void main(String[] args) {
    
        // Thread thread1 = new Thread() {
        //     public void run() {
        //         System.out.println( "This is Task 2 " );
        //     }

        // } ; 

        // Use class : task 2 
        Task2 task2 = new Task2() ; 
        Thread thread2 = new Thread() ;

        PrintHelloThread t = new PrintHelloThread();

        // t.start();
        thread2.start();

        try {
            // t.join();
            thread2.join();
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        System.out.println("main thread terminated");
    }


}
