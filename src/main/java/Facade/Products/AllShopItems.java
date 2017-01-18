package Facade.Products;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class AllShopItems {

    @Id
    private String name;

    @Column(nullable = false)
    private String price;

    @Column
    private String type;

    @Column(nullable = false)
    private String quntity;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String quntityValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuntity() {
        return quntity;
    }

    public void setQuntity(String quntity) {
        this.quntity = quntity;
    }

    public String getQuntityValue() {
        return quntityValue;
    }

    public void setQuntityValue(String quntityValue) {
        this.quntityValue = quntityValue;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
