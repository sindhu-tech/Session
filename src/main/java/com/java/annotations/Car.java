package com.java.annotations;


import lombok.NonNull;

public  class Car extends Vehicle{
    int car_id;

    public Car() {

    }

    public Car(@NonNull int car_id) {
        this.car_id = car_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id( @NonNull int car_id) {
        this.car_id = car_id;
    }


    @Override
    public void displayText(){
        System.out.println("This is a car class");
    }
    @Deprecated
    public void carEngine(){
        System.out.println("This is Car engine functions ");
    }

    @MyCustomAnnotation(car_name="xuv",cost="7.96",company="Mahidar")
    public void display(){
        System.out.println("Annotation");
    }


}
