package com.revature.cookbook.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewRecipeRequest {
    private String name;
    private String token;
    private int calorie;
    private int upperRange;
    private int lowerRange;

}
