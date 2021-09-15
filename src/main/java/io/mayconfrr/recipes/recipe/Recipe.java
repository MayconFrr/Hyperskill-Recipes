package io.mayconfrr.recipes.recipe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Recipe {
    @JsonIgnore
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String description;

    @NotNull
    @Size(min = 1)
    @ElementCollection
    @Column(nullable = false)
    private List<String> ingredients;

    @NotNull
    @Size(min = 1)
    @ElementCollection
    @Column(nullable = false)
    private List<String> directions;
}
