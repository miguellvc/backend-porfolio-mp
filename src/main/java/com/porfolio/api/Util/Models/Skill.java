package com.porfolio.api.Util.Models;


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
    private Long porcentage;

    @Getter @Setter @Column(name = "background")
    private String background;

    @Getter @Setter @Column(name = "border")
    private String border;

    @Getter @Setter @Column(name = "color")
    private String color;

    @Getter @Setter @Column(name = "rotate")
    private String rotate;

}
