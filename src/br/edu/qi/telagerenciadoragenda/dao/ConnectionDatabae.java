/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.telagerenciadoragenda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabae {
    
    private static final String URL_MYSQL = "jdbc:mysql://localhost/agenda";
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String USER = "william";
    private static final String PASS = "william";
    
    public static Connection getConnection(){
        System.out.println("Conectando ao Banco de dados");
        try {
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(URL_MYSQL, USER, PASS);
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }
    
}
