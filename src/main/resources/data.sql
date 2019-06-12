INSERT INTO Position (position, description)
VALUES ('Junior', 'Стажер');
INSERT INTO Position (position, description)
VALUES ('Middle', 'Самостоятельный программист');
INSERT INTO Position (position, description)
VALUES ('Senior', 'Высший уровень программиста');

INSERT INTO Classroom (cabinet, description)
VALUES ('Room1', 'Кабинет математики');
INSERT INTO Classroom (cabinet, description)
VALUES ('Room2', 'Кабинет информатики');
INSERT INTO Classroom (cabinet, description)
VALUES ('Room3', 'Кабинет английского');

INSERT INTO Project (project, description)
VALUES ('Google', 'Искуственный интелект');
INSERT INTO Project (project, description)
VALUES ('Apple', 'Создание сайтов');
INSERT INTO Project (project, description)
VALUES ('Microsoft', 'Тестирование');


INSERT INTO Employee (id, version, first_name, second_name, middle_name, birthday, position, cabinet, salary)
VALUES (1, 0, 'Иван', 'Смирнов', 'Петрович','1995-09-05', 'Junior', 'Room3', 1000);

INSERT INTO Employee (id, version, first_name, second_name, middle_name, birthday, position, cabinet, salary)
VALUES (2, 0, 'Максим', 'Акинфеев', 'Максимович','1990-08-04', 'Senior', 'Room1', 5000);

INSERT INTO Employee (id, version, first_name, second_name, middle_name, birthday, position, cabinet, salary)
VALUES (3, 0, 'Максим', 'Акинфеев', 'Александрович','1993-12-31', 'Middle', 'Room1', 2000);

INSERT INTO Employee_Project(employee_id, project_id)
VALUES (1,0);
INSERT INTO Employee_Project(employee_id, project_id)
VALUES (2,1);
INSERT INTO Employee_Project(employee_id, project_id)
VALUES (1,1);
INSERT INTO Employee_Project(employee_id, project_id)
VALUES (3,2);