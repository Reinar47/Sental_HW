CREATE TABLE IF NOT EXISTS game_character_weapon
(
    character_id       bigint         NOT NULL,
    weapon_id          bigint         NOT NULL,
    PRIMARY KEY (character_id, weapon_id),

    CONSTRAINT fk_gcw_character
        FOREIGN KEY (character_id) REFERENCES game_character (character_id) ON DELETE CASCADE,
    CONSTRAINT fk_gcw_weapon
        FOREIGN KEY (weapon_id) REFERENCES weapon (weapon_id) ON DELETE CASCADE
);