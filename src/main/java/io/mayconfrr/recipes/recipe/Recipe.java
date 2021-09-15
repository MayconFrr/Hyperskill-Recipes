package io.mayconfrr.recipes.recipe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Recipe {
    @JsonIgnore
    private Long id;
    private String name;
    private String description;
    private List<String> ingredients;
    private List<String> directions;
}
