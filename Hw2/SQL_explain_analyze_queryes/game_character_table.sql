EXPLAIN ANALYZE
SELECT * FROM game_character gc
INNER JOIN ability_scores a ON gc.ability_scores_id = a.ability_scores_id;

EXPLAIN ANALYZE
SELECT * FROM game_character gc
INNER JOIN character_race cr ON gc.race_id = cr.race_id;

EXPLAIN ANALYZE
SELECT * FROM game_character gc
INNER JOIN character_class cc ON gc.class_id = cc.class_id;

EXPLAIN ANALYZE
SELECT * FROM game_character gc
INNER JOIN armor a ON gc.armor_id = a.armor_id;

EXPLAIN ANALYZE
SELECT * FROM game_character gc
INNER JOIN user_account ua ON gc.user_id = ua.user_id;

SELECT indexname, indexdef
FROM pg_indexes
WHERE tablename = 'game_character';