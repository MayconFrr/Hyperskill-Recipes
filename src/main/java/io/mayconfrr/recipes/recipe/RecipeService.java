package io.mayconfrr.recipes.recipe;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeDao recipeDao;

    public Long saveRecipe(Recipe recipe) {
        return recipeDao.save(recipe);
    }

    public Recipe getRecipeById(Long id) {
//        return recipeDao.findById(id);
        return null;
    }

    public void deleteRecipeById(Long id) {
    }
}
