-- TABLE POST
CREATE TABLE POST (
                      ID INT AUTO_INCREMENT PRIMARY KEY,
                      TITLE VARCHAR(1000) NOT NULL,
                      POST_DATE DATE NOT NULL
);

-- TABLE POST_COMMENT
CREATE TABLE POST_COMMENT (
                              ID INT PRIMARY KEY,
                              REVIEW VARCHAR(1000),
                              COMMENT_DATE DATE NOT NULL,
                              POST_ID INT,
                              CONSTRAINT FK_POST_COMMENT_POST_ID
                                  FOREIGN KEY (POST_ID)
                                      REFERENCES POST(ID)
);