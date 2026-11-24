package ru.sental.mainmodulespring.dto.response.lists;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.sental.mainmodulespring.dto.response.MonsterResponse;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonsterResponseList {

    List<MonsterResponse> items;
}
