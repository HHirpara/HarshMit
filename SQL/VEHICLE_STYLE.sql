CREATE TABLE STYLE
(
STYLE_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
STYLE VARCHAR(30),
CREATED TIMESTAMP DEFAULT NOW(),
CREATED_BY	VARCHAR(30),
MODIFIED TIMESTAMP DEFAULT NOW()
MODIFIED_BY VARCHAR(30)
);