package code.practice.concepts.threads;

public class ThreadOnNumbers {
    private int count = 0;
    private  boolean isComplete = false;

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    private void increment(){
        synchronized (this){
            count++;
        }
    }

    public synchronized void printTill(int limit){
        if(!isComplete)
        {
            try {
                wait();
            }
            catch (Exception e){
                System.out.println(e.getCause());
            }
        }
        while(count <= limit){
            increment();
            System.out.println(count + Thread.currentThread().getName());
        }
        notifyAll();
    }
}
