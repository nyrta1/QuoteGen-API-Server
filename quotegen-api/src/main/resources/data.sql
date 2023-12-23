CREATE TABLE IF NOT EXISTS Quote_Tags (
    id BIGSERIAL PRIMARY KEY,
    tag_name VARCHAR
);

CREATE TABLE IF NOT EXISTS Quote_Content (
    id BIGSERIAL PRIMARY KEY,
    author VARCHAR,
    content VARCHAR,
    tag_id INT REFERENCES Quote_Tags(id),
    date_added DATE,
    date_modified DATE
);