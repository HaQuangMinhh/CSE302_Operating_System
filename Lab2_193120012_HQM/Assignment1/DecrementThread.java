public class DecrementThread extends Thread {

    private Data data ;

    public DecrementThread(Data data) {
        this.data = data ;
    }

    @Override
    public void run() {
        for ( int i = 0 ; i < 1000000 ; i++ ) {
            data.decrease();
        }
    } 
    
}
