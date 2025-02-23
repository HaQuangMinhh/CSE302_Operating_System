public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyBarrier barrier = new MyBarrier(3); 

        TestRunnable tr1 = new TestRunnable(barrier); 
        Thread t1 = new Thread(tr1); 
        t1.start();

        TestRunnable tr2 = new TestRunnable(barrier); 
        Thread t2 = new Thread(tr2); 
        t2.start();

        TestRunnable tr3 = new TestRunnable(barrier); 
        Thread t3 = new Thread(tr3); 
        t3.start();

        t1.join();
        t2.join();
        t3.join();   // Chờ t2 kết thuc moi chay t3 dc
        
        System.out.println("Done.");

    }
}

class TestRunnable implements Runnable {

    private MyBarrier barrier ; 

    public TestRunnable( MyBarrier barrier ) {
        this.barrier = barrier ; 
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is waiting at the barrier.");
        try {
            this.barrier.await();
            System.out.println(Thread.currentThread().getName() + " has crossed the barrier.");
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
    }

    

}
