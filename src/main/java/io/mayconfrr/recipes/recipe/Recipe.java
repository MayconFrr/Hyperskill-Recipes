package io.mayconfrr.recipes.recipe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Recipe {
    @JsonIgnore
    private Long id;
    private String name;
    private String description;
    private String ingredients;
    private String directions;
}
