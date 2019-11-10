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
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		 
		if(MenuOp == "livros") {
			try {
				Object[] colNames = {"Titulo", "Autores", "ISBN", "Preço", "Editora", "Editar", "Deletar"};
				TableBooksController.preencheTabela("livros", tabela,colNames,7);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
    
}
