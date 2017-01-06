DROP TABLE IF EXISTS student;
CREATE TABLE student (
  id         BIGINT       NOT NULL IDENTITY PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(255) NOT NULL,
  last_name  VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS course;
CREATE TABLE course (
  id          BIGINT       NOT NULL IDENTITY PRIMARY KEY AUTO_INCREMENT,
  title       VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS student_course;
CREATE TABLE student_course (
  student_id BIGINT NOT NULL,
  course_id  BIGINT NOT NULL,
  PRIMARY KEY (student_id, course_id)
);