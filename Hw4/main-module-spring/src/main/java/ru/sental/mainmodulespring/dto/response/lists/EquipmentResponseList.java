package ru.sental.mainmodulespring.dto.response.lists;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.sental.mainmodulespring.dto.response.EquipmentResponse;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentResponseList {

    List<EquipmentResponse> items;
}
