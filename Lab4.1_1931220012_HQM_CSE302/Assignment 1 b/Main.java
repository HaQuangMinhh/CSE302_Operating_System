public class Main {

    public static final int N = 1000000 ; 

    public static void main(String[] args) throws InterruptedException {
        
        Data sharedData = new Data(0);

        IncreaseThread t1 = new IncreaseThread(sharedData);
        DecreaseThread t2 = new DecreaseThread(sharedData);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Shared Data: " + sharedData.getData() );
    }


}

class IncreaseThread extends Thread {
    private Data sharedData ; 

    public IncreaseThread ( Data d ) {
        this.sharedData = d ; 
    }

    @Override
    public void run() {
        for ( int i = 0 ; i < Main.N ; i++ ) {
            this.sharedData.increase();
        }
    }
}

class DecreaseThread extends Thread {
    private Data sharedData ; 

    public DecreaseThread ( Data d ) {
        this.sharedData = d ; 
    }

    @Override
    public void run() {
        for ( int i = 0 ; i < Main.N ; i++ ) {
            this.sharedData.decrease();
        }
    }
}
