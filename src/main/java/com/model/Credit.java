package com.model;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;
public class Credit {
    private UUID id;
    @NotNull
    private long limitCredit;
    @NotNull
    private long interestRate;
    public Credit(UUID id, long limitCredit, long interestRate){
        this.id = id;
        this.limitCredit = limitCredit;
        this.interestRate = interestRate;
    }
    public Credit(long limitCredit, long interestRate) {
        this.limitCredit = limitCredit;
        this.interestRate = interestRate;
    }
    public  void setId(UUID id){
        this.id = id;
    }
    public void setLimitCredit(long limitCredit){
        this.limitCredit = limitCredit;
    }
    public void setInterestRate(long interestRate){
        this.interestRate = interestRate;
    }
    public  UUID getId(){
        return id;
    }
    public long getLimitCredit(){
        return limitCredit;
    }
    public long getInterestRate(){
        return interestRate;
    }
    @Override
    public String toString() {
        return limitCredit + " " + interestRate;
    }
}
