package daos;

import factories.DatabaseFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.BookModel;
import models.PublisherModel;

public class PublisherDAO {

    public PublisherDAO() {
    }

    public ArrayList<PublisherModel> index() throws Throwable {
        final String query = "SELECT * FROM public.publishers;";
        Connection db = DatabaseFactory.getConnection();
        ArrayList<PublisherModel> publisherList = new ArrayList<>();

        try {
            Statement stm = db.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                //System.out.println("Nome: " + rs.getString(2) + "URL: " + rs.getString(3));
                PublisherModel publisher = new PublisherModel(rs.getString("name"), rs.getString("url"));
                publisherList.add(publisher);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        db.close();  
        return publisherList;
    }
    
    public ArrayList<PublisherModel> getPublisherByName(String name){
    	ArrayList<PublisherModel> publisherList = new ArrayList<>();
    	Connection db = DatabaseFactory.getConnection();
    	final String query = "SELECT * FROM public.publishers WHERE LOWER(name) LIKE LOWER(?);";
    	
    	try {
    		
    		PreparedStatement pstm = db.prepareStatement(query);
    		pstm.setString(1, "%" + name + "%");
    		ResultSet rs = pstm.executeQuery();
    		
    		while(rs.next()) {
    			PublisherModel publisher = new PublisherModel(rs.getString("name"), rs.getString("url"));
                publisherList.add(publisher);
    		}

    		db.close();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
    	
    	
    	return publisherList;
    }

    public Boolean store(PublisherModel publisher) throws Throwable {
        final String query = "INSERT INTO public.publishers(name, url) VALUES (?, ?);";
        Connection db = DatabaseFactory.getConnection();

        try {
            PreparedStatement pstm = db.prepareStatement(query);
            pstm.setString(1, publisher.getName());
            pstm.setString(2, publisher.getUrl());
            int r = pstm.executeUpdate();
            System.out.println("Linhas modificadas: " + r);

            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        db.close();  
        return false;
    }

    /**
     *
     * @param publisher_id
     * @return
     * @throws java.sql.SQLException
     */
    public static PublisherModel edit(Integer publisher_id) throws SQLException {
        final String query = "SELECT * FROM public.publishers WHERE publisher_id = ?;";
        Connection db = DatabaseFactory.getConnection();
        PublisherModel publisher = new PublisherModel();

        try {
            PreparedStatement pstm = db.prepareStatement(query);
            pstm.setInt(1, publisher_id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                publisher.setName(rs.getString("name"));
                publisher.setUrl(rs.getString("url"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        db.close(); 
        return publisher;
    }

    public Boolean update(String name, String url, Integer publisher_id) throws Throwable {
        final String query = "UPDATE public.publishers SET name = ? , url = ? WHERE publisher_id = ?;";
        Connection db = DatabaseFactory.getConnection();

        try {
            PreparedStatement pstm = db.prepareStatement(query);
            pstm.setString(1, name);
            pstm.setString(2, url);
            pstm.setInt(3, publisher_id);
            int r = pstm.executeUpdate();
            System.out.println("Linhas modificadas: " + r);

            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        db.close(); 
        return false;
    }

    public Boolean delete(Integer publisher_id) throws Throwable {
        final String query = "DELETE FROM public.publishers WHERE publisher_id = ?;";
        Connection db = DatabaseFactory.getConnection();

        try {
            PreparedStatement pstm = db.prepareStatement(query);
            pstm.setInt(1, publisher_id);
            int r = pstm.executeUpdate();
            System.out.println("Linhas modificadas: " + r);

            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        db.close(); 
        return false;
    }
    
    public Boolean check(PublisherModel publisher) {
    	Connection db = DatabaseFactory.getConnection();
    	final String query = "SELECT * FROM public.publishers WHERE LOWER(name) LIKE LOWER(?) AND url = ?;";
    	
    	try {
    		
    		PreparedStatement pstm = db.prepareStatement(query);
    		pstm.setString(1, publisher.getName());
    		pstm.setString(2, publisher.getUrl());
    		ResultSet rs = pstm.executeQuery();
    		
    		db.close();
    		
    		if(rs.next()) {
    			// retorna verdadeiro se existir
    			return true;
    		} else {
    			// retorna falso se n�o existir
    			return false;
    		} 		
        	
			
		} catch (SQLException e) {
			System.out.println(e);
		}
    	
    	
    	return true;
    }
}
