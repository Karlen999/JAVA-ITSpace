package adportal.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data

public class Ad implements Serializable {

    private String title;
    private String text;
    private double price;
    private Date date;
    private Category category;
    private User user;

    public Ad(String title, String text, double price, Date date, Category category, User user) {
        this.title = title;
        this.text = text;
        this.price = price;
        this.date = date;
        this.category = category;
        this.user = user;
    }


}