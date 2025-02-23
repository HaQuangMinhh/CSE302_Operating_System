import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OldBridge {

    public static final int MAX_CARS = 3 ; 

    private ReentrantLock lock = new ReentrantLock();
    
    private Condition cond0 = this.lock.newCondition(); 
    private Condition cond1 = this.lock.newCondition(); 


    private int count0 = 0 ; 
    private int count1 = 1 ; 

    public OldBridge(  ) {

    }

    public void arrive ( int dir ) throws InterruptedException {
        this.lock.lock();

        try {
            if ( dir == 0  ) {  // -->
                if ( count1 > 0 ) {   // trên cầu có 1 xe đi ngược lại, chỉ có chờ thôi
                    this.cond0.await(); // wait
                    
                } else if ( count0 < MAX_CARS )  {
                    this.count0++; 
                    
                } else {
                    // wait
                    this.cond0.await();
                }
    
            } else {  // <--
                // tuong tu 
                while ( true ) {
                    if ( count0 > 0 ) {
                        this.cond1.await();
                    } else if ( count1 < MAX_CARS ) {
                        this.count1++;
                        break ; 
                    } else {
                        this.cond1.await();
                    }

                }
            }
        } finally {
            this.lock.unlock();
        }

        

    }

    public void exit( int dir  ) {
        this.lock.lock();
        try {
            if ( dir == 0  ) {
                count0--;
                if (count0 == 0) {
                    cond1.signalAll();  // Cầu trống, cho xe hướng ngược lại đi
                } else {
                    cond0.signalAll();  // Vẫn còn xe cùng hướng chờ
                }
            } else {
                count1--;
                if (count1 == 0) {
                    cond0.signalAll();  // Cầu trống, cho xe hướng ngược lại đi
                } else {
                    cond1.signalAll();  // Vẫn còn xe cùng hướng chờ
                }
            }

        } finally {
            this.lock.unlock();
        }
    }
}
