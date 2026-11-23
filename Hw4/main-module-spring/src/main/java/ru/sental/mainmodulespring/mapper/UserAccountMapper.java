package ru.sental.mainmodulespring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.sental.mainmodulespring.constant.UserRole;
import ru.sental.mainmodulespring.dto.request.UserAccountRequest;
import ru.sental.mainmodulespring.dto.response.UserAccountResponse;
import ru.sental.mainmodulespring.entity.GameCharacter;
import ru.sental.mainmodulespring.entity.Monster;
import ru.sental.mainmodulespring.entity.UserAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {

    @Mapping(target = "userRole", source = "userAccountRequest", qualifiedByName = "resolveUserRole")
    UserAccount toUserAccountEntity(UserAccountRequest userAccountRequest);

    @Named("resolveUserRole")
    default UserRole resolveUserRole(UserAccountRequest userAccountRequest) {
        if (userAccountRequest.getUserRole() == null) {
            return UserRole.PLAYER;
        }
        String role = userAccountRequest.getUserRole();

        return UserRole.valueOf(role.toUpperCase());
    }

    /**
     * У игрока не может быть списка монстров, а у мастера - списка игроков
     */
    @Mapping(target = "gameCharacters", source = "userAccount",  qualifiedByName = "resolveGameCharacters")
    @Mapping(target = "monsters", source = "userAccount",  qualifiedByName = "resolveMonsters")
    UserAccountResponse toUserAccountResponse(UserAccount userAccount);

    List<UserAccountResponse> toUserAccountResponseList(List<UserAccount> userAccounts);

    @Named("resolveGameCharacters")
    default List<Long> resolveGameCharacters(UserAccount userAccount) {
        if (userAccount.getUserRole().equals(UserRole.PLAYER)){
            return userAccount.getGameCharacters().stream()
                    .map(GameCharacter::getCharacterId)
                    .toList();
        }
        return new ArrayList<>();
    }

    @Named("resolveMonsters")
    default List<Long> resolveMonsters(UserAccount userAccount){
        if (userAccount.getUserRole().equals(UserRole.GAME_MASTER)){
            return userAccount.getMonsters().stream()
                    .map(Monster::getId)
                    .toList();
        }
        return new ArrayList<>();
    }

}

