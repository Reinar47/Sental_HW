package ru.sental.mainmodulespring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterClassResponse {

    private long classId;

    private String className;

    private String classDescription;
}
