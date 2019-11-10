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
    public AuthorModel(Integer id_author, String name, String fname) {
        this.name = name;
        this.fname = fname;
        this.author_id = id_author;
    }

    public Integer getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(Integer author_id) {
		this.author_id = author_id;
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