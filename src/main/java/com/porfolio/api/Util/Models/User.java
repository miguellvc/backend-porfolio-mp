package com.porfolio.api.Util.Models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "name")
    private String name;
    @Getter @Setter @Column(name = "surname")
    private String surname;
    @Getter @Setter @Column(name = "mail")
    private String mail;
    @Getter @Setter @Column(name = "password")
    private String password;

}
