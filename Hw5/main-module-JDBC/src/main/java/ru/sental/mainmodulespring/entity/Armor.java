package ru.sental.mainmodulespring.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.sental.mainmodulespring.constant.ArmorClass;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Armor {


    private long armorId;

    private String armorName;

    private ArmorClass armorClass;

    private int armorWeightLbs;

    private String armorDescription;

    private Boolean armorEquipped;

    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<GameCharacter> gameCharacter = new ArrayList<>();

}
