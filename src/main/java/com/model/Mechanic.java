package com.model;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class Mechanic {
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String middleName;
    private int hourPrice;

    public Mechanic() {
    }

    public Mechanic(UUID id, String name, String surname, String middleName, int hourPrice) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.hourPrice = hourPrice;
    }
        public Mechanic(String name, String surname, String middleName, int hourPrice) {
            this.name = name;
            this.surname = surname;
            this.middleName = middleName;
            this.hourPrice = hourPrice;
        }




        public void setId(UUID id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }
        public  UUID  getId(){
        return id;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public int getHourPrice() {
            return hourPrice;
        }

        public void setHourPrice(int hourPrice) {
            this.hourPrice = hourPrice;
        }

        @Override
    public String toString() {
        return this.surname +" "+this.name +" "+  this.middleName;
    }
}
