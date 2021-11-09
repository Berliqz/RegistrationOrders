package com.repository;

import com.model.Client;
import com.sun.scenario.effect.light.SpotLight;

import java.sql.SQLOutput;
import java.util.UUID;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {

    @Override
    public void insert(Client obj) {
        String sql = "INSERT INTO Client (name,surname,middleName,passportNumber,phoneNumber,email) VALUES (?,?,?,?,?,?)";
        sqlCommand(obj, sql);
    }

    @Override
    public List<Client> findAll() {
        String sql = "SELECT * FROM Client;";
        PreparedStatement preparedStatement = BaseConnect.preparedStatement(sql);
      return resultSet(preparedStatement);
   }

    @Override
    public void update(Client obj) {
        String sql = "UPDATE Client Set name = ?  , surname = ? ,middleName = ? , passportNumber =?,  phoneNumber = ?, email = ?  WHERE id=" + obj.getId() + ";";
        sqlCommand(obj, sql);
    }

    @Override
    public boolean deleteById(UUID id) {
        try {
            String sql = "DELETE FROM Client WHERE id=" + id;
            PreparedStatement preparedStatement = BaseConnect.preparedStatement(sql);
            int result = preparedStatement.executeUpdate();
            return result!=0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Client getById(UUID id) {
        String sql = "SELECT * FROM Client WHERE id=" + id;
        PreparedStatement preparedStatement = BaseConnect.preparedStatement(sql);
        return resultSet(preparedStatement).get(0);
    }

    private void sqlCommand(Client obj, String sql) {
        try {
            PreparedStatement preparedStatement = BaseConnect.preparedStatement(sql);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setString(2, obj.getSurname());
            preparedStatement.setString(3, obj.getMiddleName());
            preparedStatement.setLong(4, obj.getPassportNumber());
            preparedStatement.setLong(5, obj.getPhoneNumber());
            preparedStatement.setString(6, obj.getEmail());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> findAllByFragments(String text) {
        PreparedStatement preparedStatement;
        String sql;
        try {

            UUID id = UUID.fromString(text);
            sql = "SELECT * FROM Client WHERE id= ? OR email = ? or phoneNumber or passportNumber= ? or name like ? OR surname like ? OR middleName like ?";
            preparedStatement = BaseConnect.preparedStatement(sql);
            preparedStatement.setObject(1, id);
            preparedStatement.setObject(2, id);
            preparedStatement.setString(3, "%" + text + "%");
            preparedStatement.setString(4, "%" + text + "%");
            preparedStatement.setString(5, "%" + text + "%");
        } catch (NumberFormatException e) {
            sql = "SELECT * FROM Client WHERE name like ? OR surname like ? OR middleName like ?";
            preparedStatement = BaseConnect.preparedStatement(sql);
            try {
                preparedStatement.setString(1, "%" + text + "%");
                preparedStatement.setString(2, "%" + text + "%");
                preparedStatement.setString(3, "%" + text + "%");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return resultSet(preparedStatement);
    }


    private List<Client> resultSet(PreparedStatement preparedStatement) {
        List<Client> clientList = new ArrayList<>();
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                clientList.add(
                        new Client(
                                (UUID) resultSet.getObject("id"),
                                resultSet.getString("name"),
                                resultSet.getString("surname"),
                                resultSet.getString("middleName"),
                                resultSet.getLong("passportNumber"),
                                resultSet.getLong("phoneNumber"),
                                resultSet.getString("email")
                        )
                );
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientList;
    }

}