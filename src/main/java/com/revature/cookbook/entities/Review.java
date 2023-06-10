package com.revature.cookbook.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    private String id;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String rid;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public Review(String comment, int rating, String username, User user, Recipe recipe) {
        this.id = UUID.randomUUID().toString();
        this.rating = rating;
        this.comment = comment;
        this.user = user;
        this.recipe = recipe;
        this.username = username;
        this.rid = recipe.getId();
    }

    public Review(String id, String recipeId, String comment, int rating, String username, User user, Recipe recipe ) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.username = username;
        this.rid = recipeId;
        this.user = user;
        this.recipe = recipe;
    }


}