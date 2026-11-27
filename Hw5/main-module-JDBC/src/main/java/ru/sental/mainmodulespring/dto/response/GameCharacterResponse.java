package ru.sental.mainmodulespring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameCharacterResponse {

    private long characterId;

    private String characterName;

    private int experience;

    private int hitPoints;

    private int maxHitPoints;

    private int level;

    private boolean characterDeleted;
}
