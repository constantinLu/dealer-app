package com.dealer.repository.entities;

import javax.persistence.*;

@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name="UserEntity.getUsername",query="select u from UserEntity u where u.username=:name")
})
public class UserEntity {

    @Id
    @Column(name = "uid")
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String username;

    @Column(name = "password")
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
