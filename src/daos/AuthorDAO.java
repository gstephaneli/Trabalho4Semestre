package daos;

import factories.DatabaseFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.AuthorModel;

public class AuthorDAO {

    public AuthorDAO() {
    }

    public ArrayList<AuthorModel> index() throws SQLException {
        final String query = "SELECT * FROM public.authors;";
        Connection db = DatabaseFactory.getConnection();
        ArrayList<AuthorModel> authorList = new ArrayList<>();

        try {
            Statement stm = db.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                // System.out.println("name: " + rs.getString(3) + rs.getString(2));
                AuthorModel author = new AuthorModel(rs.getString("name"), rs.getString("fname"));
                authorList.add(author);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        db.close(); 
        return authorList;
    }

    public ArrayList<AuthorModel> listarAutores(String bookIsbn) throws Throwable {
        final String query = "select * from public.booksauthors where isbn = ?;";
        Connection db = DatabaseFactory.getConnection();
        ArrayList<AuthorModel> authorList = new ArrayList<>();

        try {

            PreparedStatement pstm = db.prepareStatement(query);
            pstm.setString(1, bookIsbn);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                final String queryAutores = "SELECT * FROM public.authors WHERE author_id = ?;";
                PreparedStatement pstmAutores = db.prepareStatement(queryAutores);
                pstmAutores.setInt(1, rs.getInt("author_id"));
                ResultSet rsAutores = pstmAutores.executeQuery();

                while (rsAutores.next()) {

                    AuthorModel author = new AuthorModel(rsAutores.getString("name"), rsAutores.getString("fname"));
                    authorList.add(author);

                }

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        db.close();  
        return authorList;
    }

    public Boolean store(AuthorModel author) throws Throwable {
        final String query = "INSERT INTO public.authors(name, fname) VALUES (?, ?);";
        Connection db = DatabaseFactory.getConnection();

        try {
            PreparedStatement pstm = db.prepareStatement(query);
            pstm.setString(1, author.getName());
            pstm.setString(2, author.getFname());
            int r = pstm.executeUpdate();
            System.out.println("Linhas modificadas: " + r);

            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        db.close();  
        return false;
    }

    public AuthorModel edit(Integer author_id) throws Throwable {
        final String query = "SELECT * FROM public.authors WHERE author_id = ?;";
        Connection db = DatabaseFactory.getConnection();
        AuthorModel author = new AuthorModel();

        try {
            PreparedStatement pstm = db.prepareStatement(query);
            pstm.setInt(1, author_id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                // System.out.println("name: " + rs.getString(3) + rs.getString(2));
                author.setFname(rs.getString("fname"));
                author.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        db.close();  
        return author;
    }

    public Boolean update(AuthorModel author, Integer author_id) throws Throwable {
        final String query = "UPDATE public.authors SET name = ?, fname = ? WHERE author_id = ?;";
        Connection db = DatabaseFactory.getConnection();

        try {
            PreparedStatement pstm = db.prepareStatement(query);
            pstm.setString(1, author.getName());
            pstm.setString(2, author.getFname());
            pstm.setInt(3, author_id);
            int r = pstm.executeUpdate();
            System.out.println("Linhas modificadas: " + r);

            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        db.close();  
        return false;
    }

    public Boolean delete(Integer author_id) throws Throwable {
        final String query = "DELETE FROM public.authors WHERE author_id = ?;";
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
}
