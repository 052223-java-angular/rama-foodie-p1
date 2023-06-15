package com.revature.cookbook.dtos.responses;

import com.revature.cookbook.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Principal class represents the authenticated user's principal
 * information.
 */
//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FavoriteRes {
    private String recipe_id;
    private String title;
    private String url;
    private String username;

    public FavoriteRes(String recipe_id, String title, String url, String username) {
        this.recipe_id = recipe_id;
        this.title = title;
        this.url = url;
        this.username = username;
    }
}