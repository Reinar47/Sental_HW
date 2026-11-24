package ru.sental.mainmodulespring.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CharacterClass {

    private long classId;

    private String className;

    private String classDescription;

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<GameCharacter> gameCharacter = new ArrayList<>();
}
