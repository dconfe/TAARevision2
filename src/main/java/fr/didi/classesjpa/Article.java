package fr.didi.classesjpa;

import javax.persistence.*;

@Entity
@Table(name ="T_Article")
public class Article {

    private int id;
    private String marque;
    private String description;
    private double price;

    public Article(){

    }
    public Article(int id, String marque, String description, double prix) {
        this.id = id;
        this.marque = marque;
        this.description = description;
        this.price = prix;
    }

    //Getters
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId(){
        return id;
    }
    public String getMarque(){
        return marque;
    }
    public String getDescription(){
        return description;
    }
    public double getPrice(){
        return price;
    }

    //Setters
    public void setId(int id){
        this.id = id;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double prix) throws Exception {

        if (prix > 0) {
            this.price = prix;
        } else {
            throw new Exception();
        }


    }

    public String toString() {
        return "" + id + " " + marque + " " + " " +  description + " " + price;
    }





}
