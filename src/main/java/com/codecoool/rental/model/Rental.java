package com.codecoool.rental.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "rental")
@NamedQueries({
        @NamedQuery(name = "getRental", query = "SELECT rental FROM Rental rental WHERE rental.id = :id"),
        @NamedQuery(name = "getRentals", query = "SELECT rental FROM Rental rental")
})
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "city")
    private String city;

    @Column(name = "guests")
    private int numOfGuests;

    @OneToOne(cascade = CascadeType.ALL)
    private Amenity amenity;

    @OneToOne(cascade = CascadeType.ALL)
    private Facility facility;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private List<Picture> pictures = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();
    @ElementCollection
    private List<String> reservedPeriod = new ArrayList<>();


    public Rental() {
    }


    public Rental(String name, String description, double price, String city, int numOfGuests) {
        this.name = name;

        this.description = description;
        this.price = price;
        this.city = city;
        this.numOfGuests = numOfGuests;
    }

    public List<Review> getReviews() {
        return reviews;
    }


    public int getId() {
        return id;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumOfGuests() {
        return numOfGuests;
    }

    public void setNumOfGuests(int numOfGuests) {
        this.numOfGuests = numOfGuests;
    }

    public void setAmenity(Amenity amenity) {
        this.amenity = amenity;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public void setReview(Review review) {
        this.reviews.add(review);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    /*TODO class implementation missing
        public void setReservedPeriod(ReservedPeriod reservedPeriod) {
            this.reservedPeriods.add(reservedPeriod)
        }
        */
    public void setPictures(Picture picture) {
        this.pictures.add(picture);
    }


    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", city='" + city + '\'' +
                ", numOfGuests=" + numOfGuests +
                ", amenity=" + amenity +
                ", facility=" + facility +
                '}';
    }

    public void addReview(Review review) {
        reviews.add(review);
    }
}
