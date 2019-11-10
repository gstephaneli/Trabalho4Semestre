package daos;

import factories.DatabaseFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
imporpublic t models.BookModel;

public class BookDAO {
    
    public BookDAO() {}

    public ArrayList<BookModel> index() throws Throwable {
        final String query = "SELECT * FROM public.books;";
        Connection db = DatabaseFactory.getConnection();
        ArrayList<BookModel> bookList = new ArrayList<>();

        try {
            Statement stm = db.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                // System.out.println("Nome: " + rs.getString(1) + "ISBN: " + rs.getString(2) + " publisher_id: " + rs.getInt(3) + " price: " + rs.getDouble(4));
                BookModel book = new BookModel(rs.getString("title"), rs.getString("isbn"), rs.getInt("publisher_id"), rs.getDouble("price"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        db.close(); 
        return bookList;
    }
    
    public ArrayList<BookModel> getBookByName(String name){
    	ArrayList<BookModel> books = new ArrayList<>();
    	Connection db = DatabaseFactory.getConnection();
    	final String query = "SELECT * FROM public.books WHERE LOWER(title) LIKE LOWER(?);";
    	
    	try {
    		
    		PreparedStatement pstm = db.prepareStatement(query);
    		pstm.setString(1, "%" + name + "%");
    		ResultSet rs = pstm.executeQuery();
    		
    		while(rs.next()) {
    			BookModel book = new BookModel(rs.getString("title"), rs.getString("isbn"), rs.getInt("publisher_id"), rs.getDouble("price"));
    			books.add(book);
    		}

    		db.close();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
    	
    	
    	return books;
    }


    public Boolean store(BookModel book) throws Throwable {
        final String query = "INSERT INTO public.books(title, isbn, publisher_id, price) VALUES (?, ?, ?, ?);";
        Connection db = DatabaseFactory.getConnection();

        try {
            PreparedStatement pstm = db.prepareStatement(query);
            pstm.setString(1, book.getTitle());
            pstm.setString(2, book.getIsbn());
            pstm.setInt(3, book.getPublisher_id());
            pstm.setDouble(4, book.getPrice());
            int r = pstm.executeUpdate();
            System.out.println("Linhas modificadas: " + r);

            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        db.close();  
        return false;
    }

    public BookModel edit(String isbn) throws SQLException, Throwable {
        final String query = "SELECT * FROM public.books WHERE isbn = ?;";
        Connection db = DatabaseFactory.getConnection();
        BookModel book = new BookModel();

        try {
            PreparedStatement pstm = db.prepareStatement(query);
            pstm.setString(1, isbn);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                // System.out.println("Nome: " + rs.getString(1) + "ISBN: " + rs.getString(2) + " publisher_id: " + rs.getInt(3) + " price: " + rs.getDouble(4));
                book.setIsbn(rs.getString("isbn"));
                book.setTitle(rs.getString("title"));
                book.setPrice(rs.getDouble("price"));
                book.setPublisher_id(rs.getInt("publisher_id"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        db.close();  
        return book;
        
    }

    public Boolean update(BookModel book, String isbn) throws SQLException, Throwable {
        final String query = "UPDATE public.books SET title = ? , publisher_id = ?, price = ? WHERE isbn = ?;";
        Connection db = DatabaseFactory.getConnection();

        try {
            PreparedStatement pstm = db.prepareStatement(query);
            pstm.setString(1, book.getTitle());
            pstm.setInt(2, book.getPublisher_id());
            pstm.setDouble(3, book.getPrice());
            pstm.setString(4, isbn);
            int r = pstm.executeUpdate();
            System.out.println("Linhas modificadas: " + r);

            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        db.close();  
        return false;
    }

    public Boolean delete(Integer author_id) throws SQLException {
        final String query = "DELETE FROM public.books WHERE author_id = ?;";
        Connection db = DatabaseFactory.getConnection();

        try {
            PreparedStatement pstm = db.prepareStatement(query);
            pstm.setInt(1, author_id);
            int r = pstm.executeUpdate();
            System.out.println("Linhas modificadas: " + r);

            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        db.close(); 
        return false;
    }
    
    public Boolean check(BookModel book) {
    	Connection db = DatabaseFactory.getConnection();
    	final String query = "SELECT * FROM public.books WHERE LOWER(title) LIKE LOWER(?) AND isbn = ?;";
    	
    	try {
    		
    		PreparedStatement pstm = db.prepareStatement(query);
    		pstm.setString(1, book.getTitle());
    		pstm.setString(2, book.getIsbn());
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
