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
        //1. throw case 에러 catch
        //2. 더미 객체 return 3.custom error 페이지
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User createUser(User newUser){
        return userRepository.save(newUser);
    }

    public User updateUser(Long id,User updatedUser){
        User registeredUser = getUserById(id);
        registeredUser.setName(updatedUser.getName());
        registeredUser.setEmail(updatedUser.getEmail());
        return userRepository.save(registeredUser);
    }
    public User patchUser(Long id, User updatedUser){
        //patch 의 경우 user 데이터 일부 필드만 수신될 가능성
        User registeredUser = getUserById(id);
        // 업데이트된 사용자 정보가 존재하는 경우에만 업데이트합니다.
        if (updatedUser.getName() != null) {
            registeredUser.setName(updatedUser.getName());
        }
        if (updatedUser.getEmail() != null) {
            registeredUser.setEmail(updatedUser.getEmail());
        }
        return userRepository.save(registeredUser);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
