package ru.sental.mainmodulespring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterRaceResponse {

    private long raceId;

    private String raceName;

    private String raceDescription;
}
