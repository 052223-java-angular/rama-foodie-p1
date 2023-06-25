package com.revature.cookbook.dtos.responses;

//import com.revature.cookbook.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Principal class represents the authenticated user's principal
 * information.
 */
@AllArgsConstructor
@Getter
@Setter
public class RecipeInfo {
   private String recipeId;
}

