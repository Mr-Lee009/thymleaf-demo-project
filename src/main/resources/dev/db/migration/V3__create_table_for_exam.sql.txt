CREATE TABLE candidate
(
    candidate_id      INT PRIMARY KEY AUTO_INCREMENT,
    full_name         VARCHAR(100) NOT NULL,
    birth_date        DATE,
    national_id       VARCHAR(20),
    address           VARCHAR(255),
    phone             VARCHAR(15),
    email             VARCHAR(100),
    registration_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE license_type
(
    license_type_id INT PRIMARY KEY AUTO_INCREMENT,
    license_name    VARCHAR(10) NOT NULL,
    description     VARCHAR(255)
);

CREATE TABLE exam_session
(
    exam_session_id INT PRIMARY KEY AUTO_INCREMENT,
    exam_date       DATE NOT NULL,
    start_time      TIME,
    end_time        TIME,
    venue           VARCHAR(255),
    exam_type       VARCHAR(20) -- e.g., 'Theory' or 'Practical'
);

CREATE TABLE exam
(
    exam_id         INT PRIMARY KEY AUTO_INCREMENT,
    candidate_id    INT,
    exam_session_id INT,
    license_type_id INT,
    exam_datetime   DATETIME DEFAULT CURRENT_TIMESTAMP,
    score           DECIMAL(5, 2),
    result          VARCHAR(10),
    FOREIGN KEY (candidate_id) REFERENCES candidate (candidate_id),
    FOREIGN KEY (exam_session_id) REFERENCES exam_session (exam_session_id),
    FOREIGN KEY (license_type_id) REFERENCES license_type (license_type_id)
);

CREATE TABLE question
(
    question_id    INT PRIMARY KEY AUTO_INCREMENT,
    exam_type      VARCHAR(20), -- e.g., 'Theory'
    content        TEXT NOT NULL,
    image_path     VARCHAR(255),
    correct_answer CHAR(1)
);

CREATE TABLE answer_choice
(
    answer_choice_id INT PRIMARY KEY AUTO_INCREMENT,
    question_id      INT,
    label            CHAR(1) NOT NULL,
    content          TEXT    NOT NULL,
    FOREIGN KEY (question_id) REFERENCES question (question_id)
);

CREATE TABLE candidate_answer
(
    candidate_answer_id INT PRIMARY KEY AUTO_INCREMENT,
    exam_id             INT,
    question_id         INT,
    answer_choice_id    INT,
    answer_time         DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (exam_id) REFERENCES exam (exam_id),
    FOREIGN KEY (question_id) REFERENCES question (question_id),
    FOREIGN KEY (answer_choice_id) REFERENCES answer_choice (answer_choice_id)
);

CREATE TABLE license
(
    license_id      INT PRIMARY KEY AUTO_INCREMENT,
    candidate_id    INT,
    license_type_id INT,
    issue_date      DATE,
    expiry_date     DATE,
    FOREIGN KEY (candidate_id) REFERENCES candidate (candidate_id),
    FOREIGN KEY (license_type_id) REFERENCES license_type (license_type_id)
);
