/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

/**
 *
 * @author Guilherme
 */
public class ActionMenu implements ActionListener{

	//JFrame janela;
	JTable tabela;
	String MenuOp;
	public ActionMenu(String opMenu, JTable table) {
		this.MenuOp = opMenu;
		tabela = table;
	}
	TableBooksController tableBooksController = new TableBooksController();
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		 
		if(MenuOp == "livros") {
			try {
				Object[] colNames = {"Titulo", "Autores", "ISBN", "Preço", "Editora", "Editar", "Deletar"};

				tableBooksController.preencheTabela("livros", tabela, colNames);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		if( MenuOp == "autores"){
			try {
				Object[] colNames = {"Nome","Sobrenome","Editar","Deletar"};
				tableBooksController.preencheTabela("autores", tabela, colNames);
			} catch (Throwable e) {
				e.printStackTrace();
			}
	        
        }
        if(MenuOp == "editoras"){
        	try {
				Object[] colNames = {"Nome", "URL","Editar", "Deletar"};
				tableBooksController.preencheTabela("editoras", tabela, colNames);
			} catch (Throwable e) {
				e.printStackTrace();
			}
        }
		
	}
    
}
