package com.revature.cookbook.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    private String id;

     // set the column title to title
    @Column(name = "title", nullable = false)
    private String title;

     // set the column username to username
    @Column(name = "calories", nullable = false)
    private int calories;

     // set the column username to username
    @Column(name = "cusine", nullable = false)
    private String cusine;


    // by default column password is password
    @Column(nullable = false)
    private String url;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    @JsonManagedReference
    public Set<Review> reviews;
}

