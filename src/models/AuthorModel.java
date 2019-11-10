package models;

/**
 * Authors
 */
public class AuthorModel {
    String name, fname;
    Integer author_id;

    public AuthorModel() {}
    
    public AuthorModel(String name, String fname) {
        this.name = name;
        this.fname = fname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public String toString() {
        return "Author{" + "fname=" + fname + ", name=" + name + '}';
    }
}