/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.telagerenciadoragenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class GenericDao {
    private Connection connection;

    protected GenericDao() {
        this.connection = ConnectionDatabae.getConnection();
    }
    
    protected Connection getConnection(){
        return connection;
    }
    
    protected void save(String insertSql, Object... params) throws SQLException{
        
        PreparedStatement smtm = getConnection().prepareStatement(insertSql);
        
        for (int i = 0; i < params.length; i++) {
            smtm.setObject(i + 1, params[i]);
        }
        
        smtm.execute();
        smtm.close();
        connection.close();        
    }
    
    protected void update(String updateSql, Object id, Object... params) throws SQLException {
        PreparedStatement smtm = getConnection().prepareStatement(updateSql);
        
        for (int i = 0; i < params.length; i++) {
            smtm.setObject(i+1, params[i]);
        }
        
        smtm.setObject(params.length + 1, id);
        smtm.execute();
        smtm.close();
        connection.close();
    }
    
    protected void delete(String deleteSql, Object... params) throws SQLException{
        PreparedStatement smtm = getConnection().prepareStatement(deleteSql);
        
        for (int i = 0; i < params.length; i++) {
            smtm.setObject(i+1, params[i]);
        }        
        
        smtm.execute();
        smtm.close();
        connection.close();
    }
    
}
