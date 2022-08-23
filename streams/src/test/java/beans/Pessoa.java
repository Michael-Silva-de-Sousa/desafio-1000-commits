package beans;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Pessoa {
    Integer id;
    String firstName;
    String lastName;
    String email;
    String gender;
    Integer age;
}
