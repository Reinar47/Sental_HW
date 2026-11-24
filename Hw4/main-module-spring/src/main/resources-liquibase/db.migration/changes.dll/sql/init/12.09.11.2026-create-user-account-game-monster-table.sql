CREATE TABLE IF NOT EXISTS user_account_game_monster
(
    user_id            bigint         NOT NULL,
    monster_id         bigint        NOT NULL,
    PRIMARY KEY (user_id, monster_id),

    CONSTRAINT fk_uagm_user
        FOREIGN KEY (user_id) REFERENCES user_account (user_id) ON DELETE CASCADE,
    CONSTRAINT fk_uagm_monster
        FOREIGN KEY (monster_id) REFERENCES game_monster (monster_id) ON DELETE CASCADE
);