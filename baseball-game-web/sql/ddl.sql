DROP TABLE IF EXISTS MEMBER CASCADE;
CREATE TABLE MEMBER
(
    id bigint generate by DEFAULT as IDENTITY,
    name VARCHAR(255),
    PRIMARY KEY (id)
)