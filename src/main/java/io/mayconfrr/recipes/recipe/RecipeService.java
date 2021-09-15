package io.mayconfrr.recipes.recipe;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public Long saveRecipe(Recipe recipe) {
        recipe.setId(null);
        return recipeRepository.save(recipe).getId();
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElseThrow(RecipeNotFoundException::new);
    }

    public void deleteRecipeById(Long id) {
        if (!recipeRepository.existsById(id)) {
            throw new RecipeNotFoundException();
        }
        recipeRepository.deleteById(id);
    }

    public void updateRecipeById(Long id, Recipe recipe) {
    }
}
