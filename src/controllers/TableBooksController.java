/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import daos.AuthorDAO;
import daos.BookDAO;
import daos.PublisherDAO;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import models.AuthorModel;
import models.BookModel;
import models.PublisherModel;

public final class TableBooksController {
	
	
   

    public TableBooksController() {
        
    }

   
    
    
 public void preencheTabela(String textSelect, JTable table, Object[] colNames) throws Throwable{
    
    //table.getDtm().setNumRows(0);
    
    BookDAO bDao = new BookDAO();
        
    
        if("livros".equals(textSelect)){
        	Object[][] data = new Object[0][7];
        	DefaultTableModel dtm;
			table.setModel(dtm = new DefaultTableModel(data, colNames) {
        		 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     if(columnIndex == 5 || columnIndex == 6){
                         return true;
                     }
                     else{
                         return false;
                     }
                     
                 }
        	});
        	
        
        // bDao.index() retorna um arraylist de livros
        for (BookModel livro : bDao.index()) {    
            AuthorDAO authorDao = new AuthorDAO();
            authorDao.listarAutores(livro.getIsbn());
            
            String autores = "";
            
            for (AuthorModel author : authorDao.listarAutores(livro.getIsbn())) {
                // System.out.println(author.toString());
                autores += author.getFname().trim() + " " + author.getName().trim() + ", ";
            }

            // pra cada livro do arraylist executa o código abaixo
           dtm.addRow(new Object[]{
                livro.getTitle(),
                autores,
                livro.getIsbn(),
                livro.getPrice(),
                // o código da linha abaixo chama a função edit que está definida no publisherdao
                // essa função recebe como paramtro o id_publisher da tabela de livros e procura no banco
                // na tabela de publisher se existe uma editora com esse id
                // se existir a função cria um objeto com os dados dessa editora e retorna essse objeto 
                // o metodo .getName() faz com que a gente exiba na columa da tabela a propriedade nome desse objeto de publisher que foi retornado
                PublisherDAO.edit(livro.getPublisher_id()).getName(),
                "Editar",
                "Deletar"
                
            });
           
           table.setModel(dtm);
           
            //ButtonRenderer(
            table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer(table));
            table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditorLivro(new JTextField(), table));
            table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer(table));
            table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditorLivro(new JTextField(), table));
            
        	}
        
        
        }
        if("autores".equals(textSelect)){
        	Object[][] data = new Object[0][5];
        	DefaultTableModel dtm;
			table.setModel(dtm = new DefaultTableModel(data, colNames) {
        		 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     if(columnIndex == 2 || columnIndex == 3){
                         return true;
                     }
                     else{
                         return false;
                     }
                     
                 }
        	});
        	
        	AuthorDAO authorDao = new AuthorDAO();
                
           ArrayList<AuthorModel> autores = new ArrayList<>();    
               
           autores = authorDao.index();
           
        	for(AuthorModel autor: autores) {
        		dtm.addRow(new Object[]{
                        autor.getName(),
                        autor.getFname(),
                        "Editar",
                        "Deletar",
                        autor.getAuthor_id()
                    });
        			
        	}
          
               
               
               table.setModel(dtm);
               
                //ButtonRenderer(
                table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer(table));
                table.getColumnModel().getColumn(2).setCellEditor(new ButtonEditorAutor(new JTextField(), table));
                table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer(table));
                table.getColumnModel().getColumn(3).setCellEditor(new ButtonEditorAutor(new JTextField(), table));
                
        }
        	
        
        
        
		if("editoras".equals(textSelect)){
        	
        	Object[][] data = new Object[0][5];
        	
        	
        	DefaultTableModel dtm;
			table.setModel(dtm = new DefaultTableModel(data, colNames) {
        		 public boolean isCellEditable(int rowIndex, int columnIndex) {
                     if(columnIndex == 2 || columnIndex == 3){
                         return true;
                     }
                     else{
                         return false;
                     }
                     
                 }
        	});
        	
        	
        	PublisherDAO editoraDao = new PublisherDAO();
                
           ArrayList<PublisherModel> editoras = new ArrayList<>();    
               
           editoras = editoraDao.index();
           
        	for(PublisherModel editora: editoras) {
        		dtm.addRow(new Object[]{
                        editora.getName(),
                        editora.getUrl(),
                        "Editar",
                        "Deletar",
                        editora.getPublisher_id()
                       
                    });
        			
        	}
        	
			
               
               
               table.setModel(dtm);
               
                //ButtonRenderer(
                table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer(table));
                table.getColumnModel().getColumn(2).setCellEditor(new ButtonEditorEditora(new JTextField(), table));
                table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer(table));
                table.getColumnModel().getColumn(3).setCellEditor(new ButtonEditorEditora(new JTextField(), table));
                
        }
        
        
	}
        

}

