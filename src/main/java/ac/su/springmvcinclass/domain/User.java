package ac.su.springmvcinclass.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String email;

    //요구사항에 따른 비즈니스 로직을 위해서 필요한 데이터
    //Repository 에서는 DAO 를 사용하지만 Service 에서 DTO 사용하여 해결
    @Column(nullable = true)
    private double weight;

    @Column(nullable = true)
    private double height;


}
