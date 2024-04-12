package ac.su.springmvcinclass.controller;

import ac.su.springmvcinclass.domain.User;
import ac.su.springmvcinclass.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUser() {
        List<User> allUsers = userRepository.findAll();
        return ResponseEntity.ok(allUsers);
    }
}
