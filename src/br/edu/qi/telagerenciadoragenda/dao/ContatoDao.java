/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.telagerenciadoragenda.dao;

import br.edu.qi.telagerenciadoragenda.model.Contato;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDao extends GenericDao{
    
    public void salvar(Contato contato) throws SQLException{
        String insert = "INSERT INTO contato (nome, apelido, data_nascimento) VALUES (?, ?, ?)";
        
        save(insert, contato.getNome(), contato.getApelido(), contato.getDtNascimento());
    }
    
    public void alterar(Contato contato) throws SQLException{
        String update = "UPDATE contatto SET nome = ?, apelido = ?, data_nascimento = ?";
        
        update(update, contato.getId(), contato.getNome(), contato.getApelido(), contato.getDtNascimento());
    }
    
    public void excluir(long id) throws SQLException{
        String delete = "DELETE FROM contato WHERE id = ?";        
        delete(delete, id);
    }
    
    public List findContatos() throws SQLException{
        List contatos = new ArrayList();
        
        String select = "SELECT * FROM contato";
        
        PreparedStatement smtm = getConnection().prepareStatement(select);
        
        ResultSet result = smtm.executeQuery();
        
        while(result.next()){
            Contato contato = new Contato();
            contato.setId(result.getLong("id"));
            contato.setNome(result.getString("nome"));
            contato.setApelido(result.getString("apelido"));
            contato.setDtNascimento(result.getDate("data_nascimento"));
            contatos.add(contato);
        }
        
        result.close();
        smtm.close();
        getConnection().close();
        
        return contatos;
    }
    
    public Contato findByName(String nome) throws SQLException{
        String select = "SELECT * FROM contato WHERE nome = ?";
        Contato contato = null;
        PreparedStatement smtm = getConnection().prepareStatement(select);
        
        smtm.setString(1, nome);
        ResultSet result = smtm.executeQuery();
        
        while(result.next()){
            contato = new Contato();
            contato.setId(result.getLong("id"));
            contato.setNome(result.getString("nome"));
            contato.setApelido(result.getString("apelido"));
            contato.setDtNascimento(result.getDate("data_nascimento"));
        }
        
        result.close();
        smtm.close();
        getConnection().close();
        
        return contato;
    }
    
}
