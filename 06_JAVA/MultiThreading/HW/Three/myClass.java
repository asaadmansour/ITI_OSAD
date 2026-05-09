package Three;

public class myClass implements Runnable{
    private int counter1;
    private int counter2;

    // @Override
    // public void run() {
    //     while(!Thread.currentThread().isInterrupted()) {
    //         if (counter1 == counter2) {
    //             System.out.println("✅ Counters of thead: "+ Thread.currentThread().getName()+" are EQUAL: counter1=" + counter1 + ", counter2=" + counter2);
    //         } else {
    //             System.out.println("❌ Counters are "+ Thread.currentThread().getName()+" NOT EQUAL: counter1=" + counter1 + ", counter2=" + counter2);
    //         }
    //         counter1++;
    //         try {
    //             Thread.sleep(10);
    //         } catch (InterruptedException e) {
    //             e.printStackTrace();
    //             break;
    //         }
    //         counter2++;
    //     }
    // }
        @Override
    public synchronized void run() {
        while(!Thread.currentThread().isInterrupted()) {
            if (counter1 == counter2) {
                System.out.println("✅ Counters of thead: "+ Thread.currentThread().getName()+" are EQUAL: counter1=" + counter1 + ", counter2=" + counter2);
            } else {
                System.out.println("❌ Counters are "+ Thread.currentThread().getName()+" NOT EQUAL: counter1=" + counter1 + ", counter2=" + counter2);
            }
            counter1++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            counter2++;
        }
    }
}
