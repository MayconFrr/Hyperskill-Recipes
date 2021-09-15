package io.mayconfrr.recipes.recipe;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recipe")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping
    public Recipe getRecipe() {
        return recipeService.getRecipe();
    }

    @PostMapping
    public void postRecipe(@RequestBody Recipe recipe) {
        recipeService.saveRecipe(recipe);
    }
}
