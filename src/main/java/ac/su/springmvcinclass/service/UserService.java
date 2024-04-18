package ac.su.springmvcinclass.service;

import ac.su.springmvcinclass.domain.User;
import ac.su.springmvcinclass.domain.UserBmiDTO;
import ac.su.springmvcinclass.domain.UserDTO;
import ac.su.springmvcinclass.exception.UserNotFoundException;
import ac.su.springmvcinclass.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static List<UserDTO> convertToUserDTOList(List<User> userList) {
        return userList.stream()
                .map(UserDTO::fromEntity)
                .collect(Collectors.toList());
    }
    public List<UserDTO> getAllUsers() {
        //구체적인 조건, 처리 세부 사항 등등의 로직을 Service 레이어에서 처리
        List<User> allUserList = userRepository.findAll();
        return convertToUserDTOList(allUserList);
    }


    public User getUserById(long id){
        //1. throw case 에러 catch
        //2. 더미 객체 return 3.custom error 페이지
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public UserDTO getUserDTOById(long id){
        //1. throw case 에러 catch
        //2. 더미 객체 return 3.custom error 페이지
        User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return UserDTO.fromEntity(existingUser);
    }

    public UserDTO createUser(UserDTO newUser){
        User savedUser=userRepository.save(newUser.toEntity());
        return UserDTO.fromEntity(savedUser);
    }

    public UserDTO updateUser(Long id,UserDTO updatedUser){
        User registeredUser = getUserById(id);
        registeredUser.setName(updatedUser.getName());
        registeredUser.setEmail(updatedUser.getEmail());
        User savedUser=userRepository.save(registeredUser);
        return UserDTO.fromEntity(savedUser);
    }
    public UserDTO patchUser(Long id, UserDTO updatedUser){
        //patch 의 경우 user 데이터 일부 필드만 수신될 가능성
        User registeredUser = getUserById(id);
        // 업데이트된 사용자 정보가 존재하는 경우에만 업데이트합니다.
        if (updatedUser.getName() != null) {
            registeredUser.setName(updatedUser.getName());
        }
        if (updatedUser.getEmail() != null) {
            registeredUser.setEmail(updatedUser.getEmail());
        }
        User savedUser=userRepository.save(registeredUser);
        return UserDTO.fromEntity(savedUser);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public List<UserBmiDTO> findAllUserWithBmi() {
        List<User> allUsers = userRepository.findAll();
        return convertToUserBmiDTOList(allUsers);
    }

    public static List<UserBmiDTO> convertToUserBmiDTOList(List<User> userList) {
        return userList.stream()
                .map(UserBmiDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public UserBmiDTO findUserBmiDTOById(Long id) {
        User foundUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return UserBmiDTO.fromEntity(foundUser);
    }


}
