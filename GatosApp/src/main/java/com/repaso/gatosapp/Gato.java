package com.repaso.gatosapp;

/**
 *
 * @author Jean Marchesini
 */
public class Gato {
    
    private String id;
    private String url;
    private String apiKey;
    private String image;
    
    public Gato(){
        this.setApiKey(ApiKey.obtenerApiKey());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    
}
