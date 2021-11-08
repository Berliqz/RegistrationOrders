package com.repository;


import com.model.Client;
import com.model.Credit;
import  com.repository.CreditDAOlmpl;
import  com.repository.ObjectDAO;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CreditDAOlmpl implements CreditDAO {
    @Override
    public void insert(Credit obj) {
        String sql = "INSERT INTO Credit (limitCredit,interestRate) VALUES (?,?)";
        sqlCommand(obj, sql);
    }
  @Override
  public List<Credit> findAll() {
        String sql = "SELECT * FROM Credit;";
        PreparedStatement preparedStatement = BaseConnect.preparedStatement(sql);
        return resultSet(preparedStatement);
   }
    @Override
    public void update(Credit obj) {
        String sql = "UPDATE Credit Set limitCredit = ?  , interestRate = ?  WHERE id=" + obj.getId() + ";";
        sqlCommand(obj, sql);
    }
    @Override
    public boolean deleteById(UUID id) {
        try {
            String sql = "DELETE FROM Credit WHERE id=" + id;
            PreparedStatement preparedStatement = BaseConnect.preparedStatement(sql);
            int result = preparedStatement.executeUpdate();
            return result!=0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public Credit getById(UUID id) {
        String sql = "SELECT * FROM Credit WHERE id=" + id;
        PreparedStatement preparedStatement = BaseConnect.preparedStatement(sql);
        return resultSet(preparedStatement).get(0);
    }
    private void sqlCommand(Credit obj, String sql) {
        try {
            PreparedStatement preparedStatement = BaseConnect.preparedStatement(sql);
            preparedStatement.setLong(1,obj.getLimitCredit());
            preparedStatement.setLong(2, obj.getInterestRate());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Credit> findAllByFragments(String text) {
        PreparedStatement preparedStatement;
        String sql;
        try {
            UUID id = UUID.fromString(text);
            sql = "SELECT * FROM Credit WHERE id= ? OR interestRate  = ? or limitCredit  ?";
            preparedStatement = BaseConnect.preparedStatement(sql);
            preparedStatement.setObject(1, id);
            preparedStatement.setObject(2, id);
        } catch (NumberFormatException e) {
            sql = "SELECT * FROM Credit WHERE limitCredit like ? OR interestRate like ?";
            preparedStatement = BaseConnect.preparedStatement(sql);
            try {
                preparedStatement.setString(1, "%" + text + "%");
                preparedStatement.setString(2, "%" + text + "%");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return resultSet(preparedStatement);
    }

    private List<Credit> resultSet (PreparedStatement preparedStatement) {
        List<Credit> creditList = new ArrayList<>();
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                creditList .add(
                        new Credit(
                                (UUID) resultSet.getObject("id"),
                                resultSet.getLong("limitCredit"),
                                resultSet.getLong("interestRate")

                        )
                );
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return creditList;
    }
}
