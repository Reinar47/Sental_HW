EXPLAIN ANALYZE
SELECT * FROM user_account_game_monster uagm
INNER JOIN user_account ua ON uagm.user_id = ua.user_id;

EXPLAIN ANALYZE
SELECT * FROM user_account_game_monster uagm
INNER JOIN game_monster gm ON uagm.monster_id = gm.monster_id;

SELECT indexname, indexdef
FROM pg_indexes
WHERE tablename = 'user_account_game_monster';