package br.com.univillecalendar.model;

import br.com.univillecalendar.model.enums.UserEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private UUID studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private UserEnum userType;
    @OneToOne
    private Course course;
}
