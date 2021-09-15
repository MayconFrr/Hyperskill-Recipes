package io.mayconfrr.recipes.recipe;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/recipe")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable Long id) {
        return ResponseEntity.of(recipeService.getRecipeById(id));
    }

    @PostMapping("/new")
    public Map<String, Long> postRecipe(@RequestBody Recipe recipe) {
        return Map.of("id", recipeService.saveRecipe(recipe));
    }
}
