package com.example.demo.Model;

public class Author {
    private Integer Id;
    private String Firstname;
    private String Lastname;

    public Author() {
    }

    public Author(Integer Id, String firstname, String lastname) {
        this.Id = Id;
        this.Firstname = firstname;
        this.Lastname = lastname;
    }

    public Integer getId() { return Id; }

    public void setId(Integer id) { Id = id; }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "Id=" + Id +
                ", Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                '}';
    }
}
