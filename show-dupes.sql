.width 8 100
.mode columns
SELECT
  substr(hash, 0, 8),
  source,
  length(contents),
  substr(contents, 0, 100)
FROM dupes
ORDER BY LENGTH(contents) DESC;
