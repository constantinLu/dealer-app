package com.dealer.repository.entities;


import javax.persistence.*;

@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name="UserEntity.getName", query= "Select u from UserEntity u where u.username =:username")
})
public class UserEntity {

    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;

    @Column(name="userName")
    private String username;

    @Column(name="password")
    private String password;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
