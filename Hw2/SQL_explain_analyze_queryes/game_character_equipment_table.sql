EXPLAIN ANALYZE
SELECT * FROM game_character_equipment gce
INNER JOIN game_character gc ON gce.character_id = gc.character_id;

EXPLAIN ANALYZE
SELECT * FROM game_character_equipment gce
INNER JOIN equipment e ON gce.equipment_id = e.equipment_id;


SELECT indexname, indexdef
FROM pg_indexes
WHERE tablename = 'game_character_equipment';