package ru.sental.mainmodulespring.dto.response.lists;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.sental.mainmodulespring.dto.response.CharacterRaceResponse;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterRaceResponseList {

    List<CharacterRaceResponse> items;
}
