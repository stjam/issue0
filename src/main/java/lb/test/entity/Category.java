package lb.test.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 27.03.2015.
 */
@Entity
@Table(name = "cat")
public class Category implements Persistent{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="category", cascade=CascadeType.ALL)
    private List<Product> goods = new ArrayList<Product>();

    public Category() {

    }



    public Category(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }



    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public List<Product> getGoods() {
        return goods;
    }

    public void setGoods(final List<Product> goods) {
        this.goods = goods;
    }


}
