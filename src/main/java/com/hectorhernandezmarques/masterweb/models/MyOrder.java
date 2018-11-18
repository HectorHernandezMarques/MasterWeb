package com.hectorhernandezmarques.masterweb.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title = "";

    @OneToMany
    private List<OrderElement> orderElements = new ArrayList<>();

    public MyOrder(){
    }

    public MyOrder(String title){
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<OrderElement> getOrderElements() {
        return orderElements;
    }

    public void setOrderElements(List<OrderElement> orderElements) {
        this.orderElements = orderElements;
    }

    @Override
    public String toString() {
        return "MyOrder{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", orderElements=" + orderElements +
                '}';
    }
}
