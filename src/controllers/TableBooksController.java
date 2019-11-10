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
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import models.AuthorModel;
import models.BookModel;

public final class TableBooksController {
	
	
   

    public TableBooksController() throws Throwable {
        
    }

   
    
    
static public void preencheTabela(String textSelect, JTable table, Object[] colNames, int contColunas) throws Throwable{
    
    //table.getDtm().setNumRows(0);
    
    BookDAO bDao = new BookDAO();
        
    
        if("livros".equals(textSelect)){
        	Object[][] data = new Object[0][contColunas];
        	DefaultTableModel dtm = new DefaultTableModel(data, colNames);
        	table.setModel(dtm);
        	
        	
        	
        	System.out.println("entrou");
        
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
            table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JTextField(), table));
            table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer(table));
            table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JTextField(), table));
            
        }
        
        
        }
        
        
        
    
}
static class ButtonEditor extends DefaultCellEditor
{
  protected JButton btn;
   private String lbl;
   private Boolean clicked;

   public ButtonEditor(JTextField txt, JTable table ) {
    super(txt);

    btn=new JButton();
    btn.setOpaque(true);

    //WHEN BUTTON IS CLICKED
    btn.addActionListener(new ActionButtonSave(table));
  }

   //OVERRIDE A COUPLE OF METHODS
   @Override
  public Component getTableCellEditorComponent(JTable table, Object obj,
      boolean selected, int row, int col) {

      //SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
     lbl=(obj==null) ? "":obj.toString();
     btn.setText(lbl);
     clicked=true;
    return btn;
  }

  //IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
   @Override
  public Object getCellEditorValue() {

     if(clicked)
      {
      //SHOW US SOME MESSAGE
        JOptionPane.showMessageDialog(btn, lbl+" Clicked");
      }
    //SET IT TO FALSE NOW THAT ITS CLICKED
    clicked=false;
    return new String(lbl);
  }

   @Override
  public boolean stopCellEditing() {

         //SET CLICKED TO FALSE FIRST
      clicked=false;
    return super.stopCellEditing();
  }

   @Override
  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}

static class ButtonRenderer extends JButton implements  TableCellRenderer
{

  //CONSTRUCTOR
  public ButtonRenderer(JTable table) {
    //SET BUTTON PROPERTIES
    setOpaque(true);
  }
  @Override
  public Component getTableCellRendererComponent(JTable table, Object obj,
      boolean selected, boolean focused, int row, int col) {

    //SET PASSED OBJECT AS BUTTON TEXT
      setText((obj==null) ? "":obj.toString());

    return this;
  }

}

}

