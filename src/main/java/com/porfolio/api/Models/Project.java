package com.porfolio.api.Models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;


@Entity
@Table(name = "project")
public class Project implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "title")
    private String title;

    @Getter @Setter @Column(name = "urlImg")
    private String urlImg;

    @Getter @Setter @Column(name = "urlGit")
    private String urlGit;

}
