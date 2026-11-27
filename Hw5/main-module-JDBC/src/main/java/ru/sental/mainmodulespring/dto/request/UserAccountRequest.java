package ru.sental.mainmodulespring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountRequest {

    private String firstName;

    private String lastName;

    private String nickName;

    private String password;

    private String userRole;

    private String email;
}
