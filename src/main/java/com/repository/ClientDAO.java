package com.repository;

import com.model.Client;
import  com.repository.ClientDAOImpl;
import  com.repository.ObjectDAO;
import java.util.List;

public interface ClientDAO extends ObjectDAO<Client> {
    List<Client> findAllByFragments(String text);
}
