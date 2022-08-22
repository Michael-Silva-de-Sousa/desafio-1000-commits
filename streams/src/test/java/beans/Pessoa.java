package beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Pessoa {
    Integer id;
    String firstName;
    String lastName;
    String email;
    String gender;
    Integer age;
}
