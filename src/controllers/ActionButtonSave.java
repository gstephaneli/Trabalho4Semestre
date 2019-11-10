/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTable;
import models.TableBooks;
//import views.ViewAlterBook;

/**
 *
 * @author Guilherme
 */
public class ActionButtonSave implements ActionListener{

    JTable table;

    public ActionButtonSave(JTable table) {
        this.table = table;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //TableBooks tableBooks = new TableBooks();
          //tableBooks.setVisible(true);
          //tableBooks.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          //tableBooks.setjCampoTitulo(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));
          //tableBooks.setjCampoAutores(String.valueOf(table.getValueAt(table.getSelectedRow(), 1)));
          
          //tableBooks.setjCampoISBN(String.valueOf(table.getValueAt(table.getSelectedRow(), 2)));
          //tableBooks.setjCampoPreco(String.valueOf(table.getValueAt(table.getSelectedRow(), 3)));
          //tableBooks.setjCampoEditora(String.valueOf(table.getValueAt(table.getSelectedRow(), 4)));
        
        
    }
    
   
        
    
    
    
}
