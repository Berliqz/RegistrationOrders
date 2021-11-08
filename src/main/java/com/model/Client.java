package com.model;
//import com.sun.org.apache.bcel.internal.generic.ARETURN;
import java.util.UUID;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
public class Client {
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String middleName;
    @NotNull
    @Size(min = 1)
    @Min(0)
    private long passportNumber;
    private long phoneNumber;
    private String email;


    public Client(UUID id,String name,String surname, String middleName, long passportNumber,long phoneNumber,String email){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public  Client(String name,String surname, String middleName, long passportNumber,long phoneNumber,String email){
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void setId(UUID id){
        this.id = id;
    }
    public void  setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }
    public void setPassportNumber(long passportNumber){
        this.passportNumber = passportNumber;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public UUID getId() {return id;}
    public String getName(){
        return  name;
    }
    public String getSurname() {
        return surname;
    }
    public String getMiddleName() {
        return middleName;
    }
    public long getPassportNumber(){
        return passportNumber;
    }
    public long getPhoneNumber(){
        return phoneNumber;
    }
    public  String getEmail(){
        return email;
    }

    @Override
    public String toString() {
        return this.surname +" "+this.name +" "+  this.middleName+ " " + passportNumber + " " + phoneNumber + " " + this.email;
    }
}
