public class Main {

    public static final int N = 1000000;

    public static void main(String[] args) throws InterruptedException {

        TSQueue list = new TSQueue();

        AddLastThread t1 = new AddLastThread(list);
        RemoveFirstThread t2 = new RemoveFirstThread(list);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }

}

class AddLastThread extends Thread {
    private TSQueue list;

    public AddLastThread(TSQueue list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            this.list.addlast(i);
        }
    }
}

class RemoveFirstThread extends Thread {
    private TSQueue list;

    public RemoveFirstThread(TSQueue list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            this.list.removeFirst();
        }
    }

}
