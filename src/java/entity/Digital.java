/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import context.DBContext;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author CongHoangDevelop
 */
public class Digital {

    private int id;
    private String author;
    private String title;
    private String description;
    private String shortDescription;
    private Timestamp date;
    private String img;

    public Digital() {
    }

    public Digital(int id, String author, String title, String description, String shortDescription, Timestamp date, String img) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.description = description;
        this.shortDescription = shortDescription;
        this.date = date;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDate() {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("MMM dd yyyy - h:mm");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("a");
        String date = dateFormat1.format(this.date) + dateFormat2.format(this.date).toLowerCase();
        return date; 
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getImg() {
        return new DBContext().getImage()+img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Digital{" + "id=" + id + ", author=" + author + ", title=" + title + ", description=" + description + ", shortDescription=" + shortDescription + ", date=" + date + ", img=" + img + '}';
    }

    

}
