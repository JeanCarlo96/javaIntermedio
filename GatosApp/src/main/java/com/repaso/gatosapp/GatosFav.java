package com.repaso.gatosapp;

/**
 *
 * @author Jean Marchesini
 */
public class GatosFav {
    
    private String id;
    private String image_id;
    private String apiKey;
    private ImageFav image;

    public GatosFav() {
        this.setApiKey(ApiKey.obtenerApiKey());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public ImageFav getImageFav() {
        return image;
    }

    public void setImageFav(ImageFav imageFav) {
        this.image = imageFav;
    }    

    @Override
    public String toString() {
        return "GatosFav{" + "id=" + id + ", image_id=" + image_id + ", apiKey=" + apiKey + ", imageFav=" + image + '}';
    }
    
}
