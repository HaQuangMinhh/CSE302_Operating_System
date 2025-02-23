import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.*;

public class BoundedBuffer {

    private int size ;
    private LinkedList<Integer> buffer = new LinkedList<>() ; 
    private Lock lock = new ReentrantLock(); 
    private Condition fullCond = this.lock.newCondition(); // lấy từ khóa 
    private Condition emptyCond = this.lock.newCondition() ; 

    public BoundedBuffer (int size) {
        this.size = size ; 
    }

    public void add (int v ) throws InterruptedException {
        this.lock.lock();

        try {
            while ( this.buffer.size() == this.size ) {
                this.fullCond.await();  // Khi mà đầy, thì phải chờ tại đây. Ch có khóa thì tiep tuc cho
            }
            this.buffer.add(v); // chưa có khóa thì k dc chạy
            
            this.emptyCond.signal();

        } finally {
            this.lock.unlock();
        }
        
        
        
    }

    public int remove() {
        int value = 0 ; 
        this.lock.lock();
        try {
            while ( this.buffer.isEmpty() == true ) {
                this.emptyCond.await();
            }
            
            value = this.buffer.removeFirst(); // khong chay trong moi truong nhieu thread 
            this.fullCond.signal();   // chỉ dc 1 cái dc chạy th 

        } catch (InterruptedException e) {        
            e.printStackTrace();
        } finally {
            this.lock.unlock();
        }

        return value ; 
    }
    
}
