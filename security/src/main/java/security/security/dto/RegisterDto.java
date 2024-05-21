package security.security.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String lastName;
    private String firstName;
    private String middleName;
    private String className;
    private String username;
    private String password;
}
