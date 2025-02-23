import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.*;

public class Data {

    private int value ; 
    private Lock lock = new ReentrantLock(); 


    public Data(int value) {
        this.value = value ; 
    }

    public void increase() {
        this.lock.lock() ; 
        
        try {
            this.value = this.value + 1 ; 
        } finally {
            this.lock.unlock();
        }

    }

    public void decrease() {
        this.lock.lock();

        try {
            this.value = this.value - 1 ; 
        } finally {
            this.lock.unlock(); 
        }
    }


    public int getData() {
        return value;
    }

    public void setData(int value) {
        this.value = value;
    }
}
