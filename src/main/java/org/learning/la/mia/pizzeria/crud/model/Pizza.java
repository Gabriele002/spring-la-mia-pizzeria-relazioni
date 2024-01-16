package org.learning.la.mia.pizzeria.crud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "pizzas")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name must not be blank")
    @Column(nullable = false)
    private String name;
    private String description;

    @Lob
    private String photo;
    @Column(nullable = false)
    @Min(value = 1)
    @NotNull(message = "The price must be greater than 1")
    private BigDecimal price;

    @OneToMany(mappedBy = "pizza")
    private List<SpecialOffert> specialOfferts;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<SpecialOffert> getSpecialOfferts() {
        return specialOfferts;
    }

    public void setSpecialOfferts(List<SpecialOffert> specialOfferts) {
        this.specialOfferts = specialOfferts;
    }
}

