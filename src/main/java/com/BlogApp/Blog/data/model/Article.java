package com.BlogApp.Blog.data.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String description;
    private String imageUrl;
    @UpdateTimestamp
    private LocalDate dateCreated;
    @ManyToOne
    private User user;
}
