CREATE TABLE IF NOT EXISTS Quote_Tags (
    id BIGSERIAL PRIMARY KEY,
    tag_name VARCHAR
);

CREATE TABLE IF NOT EXISTS Quote_Content (
    id BIGSERIAL PRIMARY KEY,
    author VARCHAR,
    content VARCHAR,
    date_added DATE,
    date_modified DATE
);

CREATE TABLE IF NOT EXISTS Quote_Tags_Mapping (
    quote_id BIGINT REFERENCES Quote_Content(id),
    tag_id BIGINT REFERENCES Quote_Tags(id),
    PRIMARY KEY (quote_id, tag_id)
);
