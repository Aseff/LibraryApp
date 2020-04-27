/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryapp;

/**
 *
 * @author asefn
 */
public class SchoolData {
    private int id;
    private String name;
    private String surname;
    private String profile_description;
    
    public SchoolData() {
    }

    public SchoolData(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public SchoolData(int id, String name, String surname, String profile_description) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.profile_description = profile_description;
    }

    public SchoolData(String name, String surname, String profile_description) {
        this.name = name;
        this.surname = surname;
        this.profile_description = profile_description;
    }

 
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_description() {
        return profile_description;
    }

    public void setProfile_description(String profile_description) {
        this.profile_description = profile_description;
    }

    @Override
    public String toString() {
        return "SchoolData{" + ", name=" + name + ", surname=" + surname + ", profile_description=" + profile_description + '}';
    }

    
}
