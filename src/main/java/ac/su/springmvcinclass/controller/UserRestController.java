package ac.su.springmvcinclass.controller;

import ac.su.springmvcinclass.domain.UserDTO;
import ac.su.springmvcinclass.repository.UserRepository;
import ac.su.springmvcinclass.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> allUsers = userService.getAllUsers(); //1)전체 리스트 User Entity 를 DTO 로 수신
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserDTOById(@PathVariable long id) {
        UserDTO user = userService.getUserDTOById(id); //2) 유저 개별 데이터를 DTO 로 수신 필요
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        UserDTO savedUser = userService.createUser(user); //3)유저 생성 데이터도 DTO 로 전달
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO user) {
        UserDTO updatedUser = userService.updateUser(id, user); //4)유저 업데이트도 DTO 로 전달
        return ResponseEntity.ok(updatedUser);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDTO> patchUser(@PathVariable Long id, @RequestBody UserDTO user) {
        UserDTO patchedUser = userService.patchUser(id, user); //5)유저 업데이트도 DTO 로 전달
        return ResponseEntity.ok(patchedUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();

    }

}