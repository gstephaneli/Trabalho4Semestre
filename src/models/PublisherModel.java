package models;

/**
 * PublisherModel
 */
public class PublisherModel {

    String name, url;
    
    public PublisherModel() {}

    public PublisherModel(String name, String url) {
        this.name = name;
        this.url = url;
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