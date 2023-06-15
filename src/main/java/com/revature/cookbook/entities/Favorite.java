package com.revature.cookbook.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(name = "favorites",
      uniqueConstraints=
        @UniqueConstraint(columnNames={"username", "recipe_id"})
)
public class Favorite {
    @Id
    private String id;

    @Column(nullable = false)
    private String rid;

    @Column(nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public Favorite(String recipeId, String username, User user, Recipe recipe) {
        this.id = UUID.randomUUID().toString();
        this.rid = recipeId;
        this.username = username;
        this.user = user;
        this.recipe = recipe;
        this.username = username;
      
    }


}