package com.BlogApp.Blog.data.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable= false, unique= true)
    @NotNull
    private String title;
    @Column(unique= true, nullable=false)
    @NotNull
    private String description;
    private String imageUrl;
    @UpdateTimestamp
    private LocalDate dateCreated;

    @ManyToOne
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public Article(String title, String description, String imageUrl) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
