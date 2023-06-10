package com.revature.cookbook.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewReviewRequest {
    private String recipe_id;
    private String comments;
    private int rate;
}
