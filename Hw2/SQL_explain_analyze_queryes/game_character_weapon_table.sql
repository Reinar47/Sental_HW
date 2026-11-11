EXPLAIN ANALYZE
SELECT * FROM game_character_weapon gcw
INNER JOIN game_character gc ON gcw.character_id = gc.character_id;

EXPLAIN ANALYZE
SELECT * FROM game_character_weapon gcw
INNER JOIN weapon w ON gcw.weapon_id = w.weapon_id;

SELECT indexname, indexdef
FROM pg_indexes
WHERE tablename = 'game_character_weapon';