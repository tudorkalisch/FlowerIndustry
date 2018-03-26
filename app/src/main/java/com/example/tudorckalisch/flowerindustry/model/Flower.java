package com.example.tudorckalisch.flowerindustry.model;

import org.parceler.Parcel;

@Parcel
public class Flower {
    int id;
    String description;
    int price;
    String deliver_to;

    public Flower(int id, String description, int price, String deliver_to) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.deliver_to = deliver_to;
    }

    Flower() {
    }

    public double getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDeliver_to() {
        return deliver_to;
    }

    public void setDeliver_to(String deliver_to) {
        this.deliver_to = deliver_to;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", deliver_to='" + deliver_to + '\'' +
                '}';
    }
}
