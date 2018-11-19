package com.hectorhernandezmarques.masterweb.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderElement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private boolean striked = false;

    public OrderElement() {
    }

    public OrderElement(String name) {
        this(name, false);
    }

    public OrderElement(String name, boolean striked) {
        this.name = name;
        this.striked = striked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OrderElement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
