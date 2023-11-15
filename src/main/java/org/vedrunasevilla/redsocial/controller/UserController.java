package org.vedrunasevilla.redsocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.vedrunasevilla.redsocial.model.User;
import org.vedrunasevilla.redsocial.services.UserServiceI;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserServiceI userService;

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.searchUserByUsername(username);
    }

    @PostMapping
    public ResponseEntity<User> postUser(final @RequestBody User user) {

        // Guarda la persona consumiendo el servicio
        final User userSaved = userService.insertUser(user);

        // Retorna la ubicación de la persona en el sistema
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(userSaved.getId()).toUri();

        return ResponseEntity.created(location).body(userSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(final @PathVariable Long id) {
        ResponseEntity<User> uResponse = ResponseEntity.unprocessableEntity().build();
        final Optional<User> u = userService.searchUserById(id);

        if (u.isPresent()) {
            userService.deleteUser(u.get());
            uResponse = ResponseEntity.noContent().build();
        }

        return uResponse;
    }

    @PutMapping
    public ResponseEntity<User> putPerson(final @RequestBody User user) {

        // Resultado
        ResponseEntity<User> uResponse = ResponseEntity.unprocessableEntity().build();

        // Obtención de la persona por ID (PK)
        final Optional<User> uFound = userService.searchUserById(user.getId());

        // Persona obtenida
        if (uFound.isPresent()) {

            // Actualización
            user.setId(uFound.get().getId());
            userService.updateUser(user);

            // Resultado
            uResponse = ResponseEntity.noContent().build();

        }

        return uResponse;

    }

}
