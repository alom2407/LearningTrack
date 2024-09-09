package code.practice.concepts.threads;

import javax.sound.midi.Soundbank;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//Creating custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation{
    String value();
}

class MyClass{

    @MyAnnotation("Custom Annotation Example")
    public void myMethod(){
        System.out.println("Method Executed");
    }
}
public class RefelectionAndAnnotationExample {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //Get Class Object
        Class<?> clazz = MyClass.class;

        //Get method of Class
        Method method = clazz.getMethod("myMethod");

        //Check if method has annotation
        if(method.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            System.out.println("My annotation Value : "+myAnnotation.value());
        }
        method.invoke(clazz.getDeclaredConstructor().newInstance());
    }
}
