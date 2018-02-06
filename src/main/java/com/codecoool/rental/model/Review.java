package com.codecoool.rental.model;


import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double rating;
    private String text;
    
    @ManyToOne
    private User user;

    public Review() {
    }

    public Review(double rating, String text) {
        this.rating = rating;
        this.text = text;
    }

    public double getRating() {

        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
