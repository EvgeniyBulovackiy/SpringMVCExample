package ua.goit.java.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by bulov on 14.03.2017.
 */

@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private DishCategory dishCategory;

    @Column(name = "price")
    private Float price;

    @Column(name = "weight")
    private Float weight;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDishCategory(DishCategory dishCategory) {
        this.dishCategory = dishCategory;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dishCategory=" + dishCategory +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (name != null ? !name.equals(dish.name) : dish.name != null) return false;
        if (dishCategory != dish.dishCategory) return false;
        if (price != null ? !price.equals(dish.price) : dish.price != null) return false;
        return weight != null ? weight.equals(dish.weight) : dish.weight == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (dishCategory != null ? dishCategory.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }
}
