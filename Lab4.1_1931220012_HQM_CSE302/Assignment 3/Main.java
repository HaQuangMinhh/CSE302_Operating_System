public class Main {


    public static void main(String[] args) {
        
        BoundedBuffer buffer = new BoundedBuffer(5); // Kích thước buffer = 5

        // Producer thread: Thêm 10 số
        Runnable producer = () -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    buffer.add(i);
                    Thread.sleep(100); // Delay nhỏ để thấy quá trình rõ hơn
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Consumer thread: Xóa 10 số
        Runnable consumer = () -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    int val = buffer.remove();
                    Thread.sleep(150); // Delay lớn hơn producer để tạo sự cạnh tranh
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Tạo và chạy nhiều producer và consumer
        Thread p1 = new Thread(producer, "Producer-1");
        Thread p2 = new Thread(producer, "Producer-2");
        Thread c1 = new Thread(consumer, "Consumer-1");
        Thread c2 = new Thread(consumer, "Consumer-2");

        p1.start();
        p2.start();
        c1.start();
        c2.start();

        try {
            p1.join();
            p2.join();
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads finished. Test complete.");
    }

    
}
