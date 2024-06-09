/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se2finalproject.model.DTO;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
//import java.sql.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Mohsen
 */
public class PersonDTO implements Serializable{
    private String firstName;
    private String lastName;
    private int age;
    private String birthDate;

    public PersonDTO() {
    }

    public PersonDTO(String firstName, String lastName, int age, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getBirthDate() {       
        return birthDate;
    }
}
