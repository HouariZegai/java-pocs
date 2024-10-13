CREATE TABLE user_settings
(
    id        VARCHAR(50) NOT NULL PRIMARY KEY,
    settings  JSONB DEFAULT '{}'::jsonb
);