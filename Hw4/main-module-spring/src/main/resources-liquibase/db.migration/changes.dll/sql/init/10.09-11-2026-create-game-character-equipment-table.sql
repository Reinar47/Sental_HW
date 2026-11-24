CREATE TABLE IF NOT EXISTS game_character_equipment
(
    character_id   bigint    NOT NULL,
    equipment_id   bigint    NOT NULL,

    PRIMARY KEY (character_id, equipment_id),
    CONSTRAINT fk_gce_character
        FOREIGN KEY (character_id) REFERENCES game_character (character_id) ON DELETE CASCADE,
    CONSTRAINT fk_gce_equipment
        FOREIGN KEY (equipment_id) REFERENCES equipment (equipment_id) ON DELETE CASCADE
);
