package com.model;

import javax.validation.constraints.NotNull;

public class Bank {
    private long id;
    @NotNull
    private Client client;
    @NotNull
    private Credit credit;

    public Bank(long id, Client client, Credit credit){
        this.id = id;
        this.client = client;
        this.credit = credit;
    }
    public Bank( Client client, Credit credit){
        this.client = client;
        this.credit = credit;
    }
    public void setId(long id){
        this.id = id;
    }
    public void setClient(Client client){
        this.client = client;
    }
    public void setCredit(Credit credit){
        this.credit = credit;

    }
    public long getId(){
        return id;
    }
    public Client getClient(){
        return client;
    }
    public Credit getCredit(){
        return  credit;
    }
    @Override
    public  String toString(){
        return  client  + " " + credit;
    }
}
