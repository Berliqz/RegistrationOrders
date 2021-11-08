package com.repository;
import com.model.Credit;
import  com.repository.CreditDAOlmpl;
import  com.repository.ObjectDAO;
import java.util.List;
public interface CreditDAO extends ObjectDAO<Credit> {
    List<Credit> findAllByFragments(String text);
}