package ru.sental.mainmodulespring.dto.response.lists;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.sental.mainmodulespring.dto.response.WeaponResponse;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeaponResponseList {

    List<WeaponResponse> items;
}
