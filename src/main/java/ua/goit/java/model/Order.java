package ua.goit.java.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by bulov on 14.03.2017.
 */

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "employee_id")
    private Employee waiter;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(
            name = "dish_to_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dish> dishes;

    @Column(name = "table_number")
    private int tableNumber;

    @Column(name = "order_date")
    private Date orderDate;

    public void setId(long id) {
        this.id = id;
    }

    public void setWaiter(Employee waiter) {
        this.waiter = waiter;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dishes=" + dishes +
                ", tableNumber=" + tableNumber +
                ", orderDate=" + orderDate +
                '}';
    }
}
