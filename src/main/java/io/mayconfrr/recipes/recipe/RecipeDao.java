package io.mayconfrr.recipes.recipe;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class RecipeDao {
    private final List<Recipe> recipes = new ArrayList<>();
    private final AtomicLong atomicLong = new AtomicLong(1);

    public Optional<Recipe> findById(Long id) {
        return recipes.stream()
                .filter(recipe -> Objects.equals(recipe.getId(), id))
                .findFirst();
    }

    public Long save(Recipe recipe) {
        long id = atomicLong.getAndIncrement();
        recipe.setId(id);
        recipes.add(recipe);
        return id;
    }
}
