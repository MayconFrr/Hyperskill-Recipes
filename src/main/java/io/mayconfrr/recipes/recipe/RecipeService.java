package io.mayconfrr.recipes.recipe;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeDao recipeDao;

    public Long saveRecipe(Recipe recipe) {
        return recipeDao.save(recipe);
    }

    public Optional<Recipe> getRecipeById(Long id) {
        return recipeDao.findById(id);
    }
}
