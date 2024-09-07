package code.practice.concepts.threads;

public class ThreadExecution {

    public static void main(String[] args) {
        ThreadOnNumbers threadOnNumbers = new ThreadOnNumbers();
        Thread thread1 = new Thread(()->{
            threadOnNumbers.setComplete(true);
           threadOnNumbers.printTill(50);
        });
        Thread thread2 = new Thread(()->{
           threadOnNumbers.printTill(100);
        });
        thread1.start();
        thread2.start();

    }
}
