package lb.test.entity;

import lb.test.dao.CategoryDao;

import javax.persistence.*;

/**
 * Created by root on 27.03.2015.
 */
@Entity
@Table(name = "prod")
public class Product implements Persistent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "cat_id")
    private int category_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cat_id",insertable = false, updatable = false)
    private Category category;

    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    private double price;

    public Product() {

    }
    public Product (final String name, final Category category, double price) {
         CategoryDao categoryDao= new CategoryDao();
        this.productName = name;
        this.category = categoryDao.getByName(category.getName());
        this.category_id = this.category.getId();
        this.price = price;
    }

    public Integer getId() {
        return id;
    }
    public void setId(final Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
