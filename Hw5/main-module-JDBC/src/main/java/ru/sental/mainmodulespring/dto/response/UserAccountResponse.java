package ru.sental.mainmodulespring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountResponse {

    private Long userId;

    private String nickName;

    private String firstName;

    private String lastName;

    private String userRole;

    private String email;

    private List<Long> gameCharacters;

    private List<Long> monsters;

}
