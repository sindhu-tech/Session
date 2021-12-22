package com.java.annotations;
import java.lang.reflect.Method;
import java.util.Objects;
@SuppressWarnings("deprecation")
public class AnnotationsDemo {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
      //  Car car = new Car();
       Car car=new Car();
       car.displayText();
       car.carEngine();
      car.display();
      Method m=car.getClass().getMethod("display");
      MyCustomAnnotation custom=m.getAnnotation(MyCustomAnnotation.class);
      System.out.println("Car Name:"+custom.car_name());
      System.out.println("Car Cost:"+custom.cost());
      System.out.println("Company Name:"+custom.company());
        String str = "testString";
        //equivalent to obj != null;
        boolean b = Objects.nonNull(str);
        System.out.println(b);
        //shut down -print message

    }
}
