import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;


public class Data {

    private int value ; 
    private Semaphore sem = new Semaphore(1);


    public Data(int value) {
        this.value = value ; 
    }

    public void increase() throws InterruptedException {
        this.sem.acquire();

        try {
            this.value = this.value + 1 ; 
        } finally {
            this.sem.release();
        }
    }

    public void decrease() throws InterruptedException {
        this.sem.acquire();
        
        try {
            this.value = this.value - 1 ; 
        } finally {
            this.sem.release();
        }
    }


    public int getData() {
        return value;
    }

    public void setData(int value) {
        this.value = value;
    }
}
