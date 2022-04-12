package com.porfolio.api.Models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;


@Entity
@Table(name = "banner")
public class Banner implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "title")
    private String title;

    @Getter @Setter @Column(name = "content")
    private String content;

    @Getter @Setter @Column(name = "url_img")
    private String url_Img;


}
