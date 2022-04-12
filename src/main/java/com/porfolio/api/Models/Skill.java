package com.porfolio.api.Models;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;


@Entity
@Table(name = "skill")
public class Skill implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "language")
    private String language;

    @Getter @Setter @Column(name = "porcentage")
    private String porcentage;

    @Getter @Setter @Column(name = "colorBackground")
    private String colorBackground;

    @Getter @Setter @Column(name = "colorBorder")
    private String colorBorder;

    @Getter @Setter @Column(name = "color")
    private String color;

    @Getter @Setter @Column(name = "rotate")
    private String rotate;

}
