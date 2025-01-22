public class DecrementRunnable implements Runnable {

    private Data data ;

    public DecrementRunnable(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for ( int i = 0 ; i < 1000000 ; i++ ) {
            this.data.decrease();
        }
        
    } 
}
