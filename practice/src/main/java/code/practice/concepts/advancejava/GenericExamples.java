package code.practice.concepts.advancejava;

import java.util.List;

//Generic class Example
//Generic classes and methods allow you to operate on objects of various types
// while providing compile-time type safety.
class Box<T>{
    private T item;

    public T get() {
        return item;
    }

    public void set(T item) {
        this.item = item;
    }
}
//Bound type prameter
/*
* You can restrict the types that can be used as arguments for a generic class or
*  method using bounded type parameters. You can define upper bounds (extends) and
* lower bounds (super).

 */
class BoundedTypeExample<T extends Number> {
    private T number;

    public void set(T number) {
        this.number = number;
    }

    public T get() {
        return number;
    }
}

public class GenericExamples {
    public static void main(String[] args) {
//        Box<String> stringBox = new Box<>();
//        stringBox.set("Hello");
//        System.out.println(stringBox.get());
//
//        Box<Integer> integerBox = new Box<>();
//        integerBox.set(123);
//        System.out.println(integerBox.get());
//
//        Integer[] intArray = {1, 2, 3, 4};
//        String[] stringArray = {"A", "B", "C"};
//
//        printArray(intArray); // Prints: 1 2 3 4
//        printArray(stringArray); // Prints: A B C

    }

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void addNumbers(List<? super Integer> list) {
        list.add(10); // You can add Integers or subclasses of Integer
    }
    /*Wildcard Generics (?):
The ? wildcard represents an unknown type. You can use it to specify that
a method can accept a range of types rather than a specific one.

Unbounded Wildcards (?):Restricts the wildcard to a specific upper bound (subclass).
Lower Bounded Wildcards (? super): Restricts the wildcard to a specific lower bound (superclass).

*/
}
