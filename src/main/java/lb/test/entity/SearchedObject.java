package lb.test.entity;

import javax.persistence.*;

/**
 * Created by root on 29.03.2015.
 */
@Entity
public class SearchedObject {
    @Id
    private String productName;
    private String name;
    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(final String productName) {
        this.productName = productName;
    }
    public SearchedObject() {
    }
    public SearchedObject(final String name, final String productName, final Double price) {
        this.name = name;
        this.price = price;
        this.productName = productName;
    }
    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }
}
