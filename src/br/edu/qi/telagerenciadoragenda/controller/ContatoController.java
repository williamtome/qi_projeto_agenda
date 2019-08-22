/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.telagerenciadoragenda.controller;

import br.edu.qi.telagerenciadoragenda.dao.ContatoDao;
import br.edu.qi.telagerenciadoragenda.model.Contato;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ContatoController {
    
    private Date formatarData(String data) throws ParseException{
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return new Date(formato.parse(data).getTime());
    }
    
    public void salvar(String nome, String apelido, String dtNascimento) throws ParseException, SQLException{
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setApelido(apelido);
        contato.setDtNascimento(this.formatarData(dtNascimento));
        new ContatoDao().salvar(contato);
    }
    
    // FAZER MÉTODO ALTERAR, EXCLUIR E BUSCAR CONTATO PELO NOME
}
