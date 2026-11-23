package ru.sental.mainmodulespring.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.sental.mainmodulespring.constant.EquipmentType;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {

    private long equipmentId;

    private String equipmentName;


    private String equipmentDescription;

    private int equipmentAmount;

    private EquipmentType equipmentType;

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<GameCharacter> gameCharacters = new ArrayList<>();


}
