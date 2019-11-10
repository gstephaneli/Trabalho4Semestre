
package controllers;

import daos.AuthorDAO;
import models.AuthorModel;

public class AuthorController {

    public AuthorController() {
    }
    
    public Boolean addAuthor(String fname, String name) throws Throwable {
    	
    	// checa se os valores s�o nulos, vazios ou v�lidos
    	if(fname != "" && fname != null && fname.matches("[a-zA-Z_]+") && name != "" && name != null && name.matches("[a-zA-Z_]+")) {
    		Boolean res = true;
    		AuthorModel author = new AuthorModel(name, fname);
    		AuthorDAO action = new AuthorDAO();
    		
    		// checa se o autor j� existe no banco de dados
    		// se existir ele retorna falso
    		// se n�o exsitir ele adiciona e retorna true
    		if(!action.check(author)) {
    			res = action.store(author);
    		} else {
    			res = false;
    		}
    		
    		return res;
    	} else {
    		return false;
    	}
    }
}
