package io.mayconfrr.recipes.recipe;

import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    private Recipe recipe;

    public Recipe getRecipe() {
        return recipe;
    }

    public void saveRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
