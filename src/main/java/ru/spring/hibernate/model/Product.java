package ru.spring.hibernate.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private int cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Product(String title, int cost) {
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("Product [id = %d, title = %s, price = %d]", id, title, cost);
    }

    @ManyToMany
    @JoinTable(
            name = "sale",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_users")
    )
    private List<Users> usersSale;

    public List<Users> getUsers() {
        return usersSale;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
