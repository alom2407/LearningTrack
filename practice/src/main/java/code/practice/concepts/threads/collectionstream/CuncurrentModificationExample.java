package code.practice.concepts.threads.collectionstream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class CuncurrentModificationExample {
    public static void main(String[] args) {
//        for Collection arrayList modifing after creating iterator
//        ArrayList<String> list = new ArrayList<>();
//        list.add("one");
//        list.add("two");
//        list.add("thre");
//        list.add("four");
//        list.add("five");
//
//        Iterator<String> iterator = list.iterator();
//        ListIterator<String> listIterator = list.listIterator();
//        while (iterator.hasNext()){
//            String value = iterator.next();
//            if(value.equals("two"))
//                list.remove(value);
//        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // First thread iterating over the list
        Thread iteratorThread = new Thread(() -> {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println("Iterator: " + iterator.next());
                try {
                    Thread.sleep(100); // Simulate delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Second thread modifying the list
        Thread modifierThread = new Thread(() -> {
            try {
                Thread.sleep(200);  // Let the iteratorThread start first
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            list.add(5);  // Modify the list concurrently
        });

        iteratorThread.start();
        modifierThread.start();
    }
}
