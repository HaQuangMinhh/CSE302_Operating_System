

public class Data {

    private int value ; 

    public Data(int value) {
        this.value = value ; 
    }

    public synchronized void increase() {
        this.value = this.value + 1 ;  
    }

    public synchronized void decrease() {
        this.value--; 
    }


    public int getData() {
        return value;
    }

    public void setData(int value) {
        this.value = value;
    }
}
