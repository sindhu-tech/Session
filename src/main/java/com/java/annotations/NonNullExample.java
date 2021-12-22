package com.java.annotations;


import lombok.NonNull;
public class NonNullExample extends Car  {

    private int id;

        public NonNullExample(@NonNull Car car) {
            this.id = car.getCar_id();
        }




}
