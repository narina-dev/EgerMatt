package Model;

import java.io.Serializable;

public class imageBean implements Serializable {

    private int id;
    private String name;
    private int price;
    private String description;
    private String imageUrl;

    public imageBean() {
    }

    public imageBean(String productName, String productDescription, int price, String imageName) {
        name = productName;
        description = productDescription;
        imageUrl = imageName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
