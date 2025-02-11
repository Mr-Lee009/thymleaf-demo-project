CREATE TABLE Candidate
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

CREATE TABLE LicenseType
(
    license_type_id INT PRIMARY KEY AUTO_INCREMENT,
    license_name    VARCHAR(10) NOT NULL,
    description     VARCHAR(255)
);

CREATE TABLE ExamSession
(
    exam_session_id INT PRIMARY KEY AUTO_INCREMENT,
    exam_date       DATE NOT NULL,
    start_time      TIME,
    end_time        TIME,
    venue           VARCHAR(255),
    exam_type       VARCHAR(20) -- e.g., 'Theory' or 'Practical'
);

CREATE TABLE Exam
(
    exam_id         INT PRIMARY KEY AUTO_INCREMENT,
    candidate_id    INT,
    exam_session_id INT,
    license_type_id INT,
    exam_datetime   DATETIME DEFAULT CURRENT_TIMESTAMP,
    score           DECIMAL(5, 2),
    result          VARCHAR(10),
    FOREIGN KEY (candidate_id) REFERENCES Candidate (candidate_id),
    FOREIGN KEY (exam_session_id) REFERENCES ExamSession (exam_session_id),
    FOREIGN KEY (license_type_id) REFERENCES LicenseType (license_type_id)
);

CREATE TABLE Question
(
    question_id    INT PRIMARY KEY AUTO_INCREMENT,
    exam_type      VARCHAR(20), -- e.g., 'Theory'
    content        TEXT NOT NULL,
    image_path     VARCHAR(255),
    correct_answer CHAR(1)
);

CREATE TABLE AnswerChoice
(
    answer_choice_id INT PRIMARY KEY AUTO_INCREMENT,
    question_id      INT,
    label            CHAR(1) NOT NULL,
    content          TEXT    NOT NULL,
    FOREIGN KEY (question_id) REFERENCES Question (question_id)
);

CREATE TABLE CandidateAnswer
(
    candidate_answer_id INT PRIMARY KEY AUTO_INCREMENT,
    exam_id             INT,
    question_id         INT,
    answer_choice_id    INT,
    answer_time         DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (exam_id) REFERENCES Exam (exam_id),
    FOREIGN KEY (question_id) REFERENCES Question (question_id),
    FOREIGN KEY (answer_choice_id) REFERENCES AnswerChoice (answer_choice_id)
);

CREATE TABLE License
(
    license_id      INT PRIMARY KEY AUTO_INCREMENT,
    candidate_id    INT,
    license_type_id INT,
    issue_date      DATE,
    expiry_date     DATE,
    FOREIGN KEY (candidate_id) REFERENCES Candidate (candidate_id),
    FOREIGN KEY (license_type_id) REFERENCES LicenseType (license_type_id)
);
