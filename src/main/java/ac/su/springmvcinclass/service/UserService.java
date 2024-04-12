package ac.su.springmvcinclass.service;

import ac.su.springmvcinclass.domain.User;
import ac.su.springmvcinclass.exception.UserNotFoundException;
import ac.su.springmvcinclass.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        //구체적인 조건, 처리 세부 사항 등등의 로직을 Service 레이어에서 처리
        return userRepository.findAll();
    }

    public User getUserById(long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}
