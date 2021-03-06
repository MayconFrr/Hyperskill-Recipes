package io.mayconfrr.recipes.recipe;

import io.mayconfrr.recipes.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/recipe")
@RequiredArgsConstructor
@Validated
@PreAuthorize("isAuthenticated()")
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable Long id) {
        return recipeService.getRecipeById(id);
    }

    @PostMapping("/new")
    public Map<String, Long> postRecipe(@Valid @RequestBody Recipe recipe, @AuthenticationPrincipal User user) {
        recipe.setAuthor(user);
        return Map.of("id", recipeService.saveRecipe(recipe));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecipe(@PathVariable Long id, @AuthenticationPrincipal User user) {
        if (!recipeService.getRecipeById(id).getAuthor().equals(user)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        recipeService.deleteRecipeById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRecipe(@PathVariable Long id, @Valid @RequestBody Recipe recipe, @AuthenticationPrincipal User user) {
        if (!recipeService.getRecipeById(id).getAuthor().equals(user)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        recipe.setAuthor(user);
        recipeService.updateRecipeById(id, recipe);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Recipe>> searchRecipe(@RequestParam Map<String, String> params) {
        if (params.size() == 1 && params.containsKey("category")) {
            return ResponseEntity.ok(recipeService.getAllRecipesByCategory(params.get("category")));
        } else if (params.size() == 1 && params.containsKey("name")) {
            return ResponseEntity.ok(recipeService.getAllRecipesContainingName(params.get("name")));
        }
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(RecipeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void recipeNotFoundExceptionHandler() {
    }
}