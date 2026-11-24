package ru.sental.mainmodulespring.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.sental.mainmodulespring.constant.UserRole;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {

    private Long id;

    private String firstName;

    private String lastName;

    private String nickName;

    private String password;

    private UserRole userRole;

    private String email;

    boolean userDeleted;

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<GameCharacter> gameCharacters = new ArrayList<>();

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Monster> monsters = new ArrayList<>();

}
