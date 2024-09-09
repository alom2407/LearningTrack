package code.practice.concepts.designpattern;

//Defines a one-to-many dependency between objects,
// so when one object changes state, all its dependents are notified and
// updated automatically.

import java.util.ArrayList;
import java.util.List;

interface Observer{
    void update(String message);
}

class ConcreteObserver implements Observer{
    String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " Update Recieved : "+message);
    }
}
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String message;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }
}
public class ObserverPattern {
    public static void main(String[] args) {
        // Create the subject (observable)
        Subject subject = new Subject();

        // Create observers
        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");

        // Add observers to the subject
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        // Set message, which will notify all observers
        System.out.println("First notification:");
        subject.setMessage("Hello, Observers!");

        // Remove one observer and set a new message
        subject.removeObserver(observer1);

        System.out.println("Second notification:");
        subject.setMessage("Observer 1 has been removed!");
    }
}
