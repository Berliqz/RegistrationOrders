package com.repository;

import java.sql.*;

public class BaseConnect {
    private static Connection connection;
    private static String driver = "org.hsqldb.jdbcDriver";

    static {
        try {
            connection = DriverManager.getConnection("jdbc:hsqldb:mem:mymemdb", "SA", "");
            sqlCommandTable();
            sqlCommandStatus();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected static PreparedStatement preparedStatement(String sql){
        try {
          return   connection.
                  prepareStatement(sql);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    protected static Statement createStatement() {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void sqlCommandStatus() throws SQLException {
        createStatement().executeQuery("\n" +
                "INSERT INTO Status (id, description) VALUES (1,'Запланирован');\n" +
                "INSERT INTO Status (id, description) VALUES (2,'Выполнен');\n" +
                "INSERT INTO Status (id, description) VALUES (3,'Принят клиентом');\n");
    }

    private static void sqlCommandTable() throws SQLException {
        createStatement().executeQuery("CREATE TABLE Client (\n" +
                "   id UUID NOT NULL IDENTITY,\n" +
                "   name VARCHAR(255) NOT NULL,\n" +
                "   surname VARCHAR(255) NOT NULL,\n" +
                "   middleName VARCHAR(255)    NOT NULL,\n" +
                "   passportNumber BIGINT NOT NULL,\n" +
                "   phoneNumber BIGINT NOT NULL,\n" +
                "   email VARCHAR(255) NULL,\n" +
                "   PRIMARY KEY (id) \n" +
                ");\n" +
                "CREATE TABLE Mechanic (\n" +
                "   id BIGINT NOT NULL IDENTITY,\n" +
                "   name VARCHAR(255) NOT NULL,\n" +
                "   surname VARCHAR(255) NOT NULL,\n" +
                "   middleName VARCHAR(255)    NOT NULL,\n" +
                "   hourPrice double not null,\n" +
                "   PRIMARY KEY (id) \n" +
                ");\n" +
                "CREATE TABLE Credit (\n" +
                "   id UUID NOT NULL IDENTITY,\n" +
                "   limitCredit BIGINT NOT NULL,\n" +
                "   interestRate  BIGINT NOT NULL,\n" +
                "   PRIMARY KEY (id) \n" +
                ");\n" +
                "CREATE TABLE Status (\n" +
                "   id BIGINT NOT NULL IDENTITY,\n" +
                "   description VARCHAR(255) NOT NULL,\n" +
                "   PRIMARY KEY (id) \n" +
                ");\n" +
                "CREATE TABLE Orders (\n" +
                "   id BIGINT NOT NULL IDENTITY,\n" +
                "   description VARCHAR(255) NOT NULL,\n" +
                "   client BIGINT FOREIGN KEY REFERENCES Client(id),\n" +
                "   mechanic BIGINT FOREIGN KEY REFERENCES Mechanic(id),\n" +
                "   creature TIMESTAMP  NOT NULL,\n" +
                "   completion TIMESTAMP ,\n" +
                "   price double NOT NULL,\n" +
                "   status int FOREIGN KEY REFERENCES Status(id),\n" +
                "   PRIMARY KEY (id) \n" +
                ");");
    }
}
