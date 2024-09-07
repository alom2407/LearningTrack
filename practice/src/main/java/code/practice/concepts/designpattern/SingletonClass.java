package code.practice.concepts.designpattern;

public class SingletonClass {

    // creating the instance for the Singleton class
    public static SingletonClass singletonClass;

    //field or methods
    private String name;
    private String age;

    //making custructor private so new object creation is not possible
    private SingletonClass(){

    }

    public SingletonClass getInstance(){
        if(singletonClass == null)
            singletonClass = new SingletonClass();
        return singletonClass;
    }
    public static SingletonClass getSingletonClass() {
        return singletonClass;
    }

    public static void setSingletonClass(SingletonClass singletonClass) {
        SingletonClass.singletonClass = singletonClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
