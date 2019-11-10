package models;

/**
 * PublisherModel
 */
public class PublisherModel {

    String name, url;
    Integer publisher_id;
    
    public PublisherModel() {}

    public PublisherModel(String name, String url) {
        this.name = name;
        this.url = url;
    }
    

    public PublisherModel(Integer publisher_id,String name, String url) {
		
		this.name = name;
		this.url = url;
		this.publisher_id = publisher_id;
	}

	public Integer getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(Integer publisher_id) {
		this.publisher_id = publisher_id;
	}

	public void setName(String name){
        this.name = name;
    }

    public void setUrl(String url){
        this.url = url;
    }
    
    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Publisher{" + "name=" + name + ", url=" + url + '}';
    }
}