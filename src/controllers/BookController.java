
package controllers;

import daos.BookDAO;
import models.BookModel;

public class BookController {
    
	public BookController() {};
	
	public Boolean addBook(String title, String isbn, Integer publisher_id, Double price) throws Throwable {
	    	
    	// checa se os valores s�o nulos, vazios ou v�lidos
    	if(title != "" && title != null && isbn != "" && isbn != null && isbn.length() == 13 && publisher_id > 0 && publisher_id != null && price > 0 && price != null) {
    		Boolean res = true;
    		BookModel book = new BookModel(title, isbn, publisher_id, price);
    		BookDAO action = new BookDAO();
    		
    		// checa se o autor j� existe no banco de dados
    		// se existir ele retorna falso
    		// se n�o exsitir ele adiciona e retorna true
    		if(!action.check(book)) {
    			res = action.store(book);
    		} else {
    			res = false;
    		}
    		
    		return res;
    	} else {
    		return false;
    	}
    }
	
}
