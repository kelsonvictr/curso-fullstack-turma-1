package br.com.gerenciadordeprodutos.api.User.controller;

import br.com.gerenciadordeprodutos.api.Security.authentication.JwtTokenService;
import br.com.gerenciadordeprodutos.api.User.dtos.CreateUserRequest;
import br.com.gerenciadordeprodutos.api.User.dtos.LoginUserRequest;
import br.com.gerenciadordeprodutos.api.User.dtos.RecoveryJwtTokenDto;
import br.com.gerenciadordeprodutos.api.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @PostMapping("/login")
    public ResponseEntity<RecoveryJwtTokenDto> authenticateUser
            (@RequestBody LoginUserRequest loginUserRequest) {
        RecoveryJwtTokenDto token = userService.authenticateUser(loginUserRequest);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logoutUser(@RequestHeader("Authorization") String token) {
        String actualToken = token.substring(7);
        jwtTokenService.invalidateToken(token);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserRequest createUserRequest) {
        userService.createUser(createUserRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public ResponseEntity<String> getAuthenticationTest() {
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
