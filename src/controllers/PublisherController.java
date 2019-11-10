
package controllers;

import daos.PublisherDAO;
import models.PublisherModel;

public class PublisherController {
	
	public PublisherController() {};
	
	public Boolean addPublisher(String name, String url) throws Throwable {
	    	
    	// checa se os valores s�o nulos, vazios ou v�lidos
    	if(name != "" && name != null && url != "" && url != null) {
    		Boolean res = true;
    		PublisherModel publisher = new PublisherModel(name, url);
    		PublisherDAO action = new PublisherDAO();
    		
    		// checa se o autor j� existe no banco de dados
    		// se existir ele retorna falso
    		// se n�o exsitir ele adiciona e retorna true
    		if(!action.check(publisher)) {
    			res = action.store(publisher);
    		} else {
    			res = false;
    		}
    		
    		return res;
    	} else {
    		return false;
    	}
    }
}
