package ro.info.uaic.ro.pa2022lab11.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDTO {
    Long id;
    String username;
    String password;
}
