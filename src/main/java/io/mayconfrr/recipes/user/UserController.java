package io.mayconfrr.recipes.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    @PostMapping
    public void registerUser(@Valid @RequestBody User user) {
        userService.registerUser(user);
    }

    @ExceptionHandler(DuplicateUsernameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void duplicateUsernameExceptionHandler() {
    }
}
