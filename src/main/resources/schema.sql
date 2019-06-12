CREATE TABLE IF NOT EXISTS Employee (
  id                BIGINT        NOT NULL  COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
  version           INTEGER       NOT NULL  COMMENT 'Служебное поле Hibernate',
  first_name        VARCHAR(50)   NOT NULL  COMMENT 'Имя',
  second_name       VARCHAR(50)             COMMENT 'Фамилия',
  middle_name       VARCHAR(50)             COMMENT 'Отчество',
  position          VARCHAR(50)             COMMENT 'Должность',
  cabinet           VARCHAR(50)             COMMENT 'Кабинет',
  birthday          DATE                    COMMENT 'Дата рождения',
  email             VARCHAR(100)            COMMENT 'Адрес электронной почты',
  salary            BIGINT                  COMMENT 'Зарплата'
);

CREATE TABLE IF NOT EXISTS Employee_Project (
  employee_id BIGINT COMMENT 'Идентификатор сотрудника',
  project_id  BIGINT COMMENT 'Идентификатор проекта'
);

CREATE TABLE IF NOT EXISTS Position
(
  position    VARCHAR(10) COMMENT 'Должность',
  description VARCHAR(50) COMMENT 'Описание'
);

CREATE TABLE IF NOT EXISTS Project
(
  project     VARCHAR(10) COMMENT 'Проект',
  description VARCHAR(50) COMMENT 'Описание',
);

CREATE TABLE IF NOT EXISTS Classroom(
  cabinet     VARCHAR(10) COMMENT 'Кабинет',
  description VARCHAR(50) COMMENT 'Описание'
);