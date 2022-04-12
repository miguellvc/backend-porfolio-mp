package com.porfolio.api.Models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;


@Entity
@Table(name = "education")
public class Education implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "certificate")
    private String certificate;

    @Getter @Setter @Column(name = "description")
    private String description;

    @Getter @Setter @Column(name = "year")
    private String year;

    @Getter @Setter @Column(name = "color")
    private String color;

}
