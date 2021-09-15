package io.mayconfrr.recipes.recipe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Recipe {
    @JsonIgnore
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ElementCollection
    @Column(nullable = false)
    private List<String> ingredients;

    @ElementCollection
    @Column(nullable = false)
    private List<String> directions;
}
