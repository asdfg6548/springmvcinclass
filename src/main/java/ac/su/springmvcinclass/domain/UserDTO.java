package ac.su.springmvcinclass.domain;

import lombok.Getter;

@Getter  // Setter 없어도 됨
public class UserDTO {
    private Long id;
    private String name;
    private String email;

    public UserDTO() {}

    private UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public static UserDTO fromEntity(User user) {
        return new UserDTO(user);
    }

    public User toEntity() {
        User user = new User();
        user.setId(this.id);
        user.setName(this.name);
        user.setEmail(this.email);
        return user;
    }
}