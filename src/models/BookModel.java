package models;

/**
 * Books
 */
public class BookModel {

    String title, isbn;
    Integer publisher_id;
    Double price;
    
    public BookModel() {}

    public BookModel(String title, String isbn, Integer publisher_id, Double price) {
        this.title = title;
        this.isbn = isbn;
        this.publisher_id = publisher_id;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(Integer publisher_id) {
        this.publisher_id = publisher_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" + "title=" + title + ", isbn=" + isbn + ", publisher_id=" + publisher_id + ", price=" + price + '}';
    }
    
    
}
