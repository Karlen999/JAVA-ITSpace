package adportal.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private String name;
    private String surname;
    private Gender gender;
    private int age;
    private String phoneNumber;
    private String password;

    public User(){

    }

    public User(String name, String surname, Gender gender, int age, String phoneNumber, String password) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }


}