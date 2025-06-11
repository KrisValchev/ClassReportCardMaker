-- data.sql

-- Clear existing data (optional, but good for repeatable seeding in dev)
DELETE FROM grades;
DELETE FROM students;
DELETE FROM subjects;

-- Reset sequences for auto-generated IDs (important for PostgreSQL IDENTITY columns)
-- Adjust table names and sequence names as per your Hibernate naming strategy
-- Typically, sequence names are like 'table_name_id_seq' for identity columns.
ALTER SEQUENCE students_id_seq RESTART WITH 1;
ALTER SEQUENCE subjects_id_seq RESTART WITH 1;
ALTER SEQUENCE grades_id_seq RESTART WITH 1; -- CORRECTED: Sequence for the 'grades' table

-- 1. Seed Subjects (with explicit IDs for linking)
-- 'subject_name' column name matches your @Column(name="subjectName")
INSERT INTO subjects (id, subject_name) OVERRIDING SYSTEM VALUE VALUES (1, 'Mathematics');
INSERT INTO subjects (id, subject_name) OVERRIDING SYSTEM VALUE VALUES (2, 'Physics');
INSERT INTO subjects (id, subject_name) OVERRIDING SYSTEM VALUE VALUES (3, 'Chemistry');
INSERT INTO subjects (id, subject_name) OVERRIDING SYSTEM VALUE VALUES (4, 'Biology');
INSERT INTO subjects (id, subject_name) OVERRIDING SYSTEM VALUE VALUES (5, 'History');
INSERT INTO subjects (id, subject_name) OVERRIDING SYSTEM VALUE VALUES (6, 'Geography');
INSERT INTO subjects (id, subject_name) OVERRIDING SYSTEM VALUE VALUES (7, 'English Language');
INSERT INTO subjects (id, subject_name) OVERRIDING SYSTEM VALUE VALUES (8, 'Physical Education');
INSERT INTO subjects (id, subject_name) OVERRIDING SYSTEM VALUE VALUES (9, 'Computer Science');
INSERT INTO subjects (id, subject_name) OVERRIDING SYSTEM VALUE VALUES (10, 'Art');

-- 2. Seed 2 Students (with explicit IDs)
-- CORRECTED: Column names now match @Column(name="firstName"), @Column(name="lastName"), and @Column(name="schoolYear")
INSERT INTO students (id, first_name, last_name, email, school_year) OVERRIDING SYSTEM VALUE VALUES (101, 'Alice', 'Smith', 'alice.smith@example.com', 2025);
INSERT INTO students (id, first_name, last_name, email, school_year) OVERRIDING SYSTEM VALUE VALUES (102, 'Bob', 'Johnson', 'bob.j@example.com', 2025);

-- 3. Seed Grades for 2 Students for Every Subject
-- Using fixed grades for data.sql.
-- Table name 'grades', columns 'grade', 'subjectId', 'studentId'
-- IMPORTANT: 'subjectId' and 'studentId' in SQL must match @JoinColumn(name = "subjectId") and @JoinColumn(name = "studentId")
-- Student 101 (Alice Smith)
INSERT INTO grades (grade, subject_id, student_id) VALUES (5.5, 1, 101);  -- Math
INSERT INTO grades (grade, subject_id, student_id) VALUES (4.0, 2, 101);  -- Physics
INSERT INTO grades (grade, subject_id, student_id) VALUES (5.0, 3, 101);  -- Chemistry
INSERT INTO grades (grade, subject_id, student_id) VALUES (6.0, 4, 101);  -- Biology
INSERT INTO grades (grade, subject_id, student_id) VALUES (5.8, 5, 101);  -- History
INSERT INTO grades (grade, subject_id, student_id) VALUES (4.5, 6, 101);  -- Geography
INSERT INTO grades (grade, subject_id, student_id) VALUES (6.0, 7, 101);  -- English
INSERT INTO grades (grade, subject_id, student_id) VALUES (4.2, 8, 101);  -- PE
INSERT INTO grades (grade, subject_id, student_id) VALUES (5.9, 9, 101);  -- CS
INSERT INTO grades (grade, subject_id, student_id) VALUES (5.0, 10, 101); -- Art

-- Student 102 (Bob Johnson)
INSERT INTO grades (grade, subject_id, student_id) VALUES (4.8, 1, 102);  -- Math
INSERT INTO grades (grade, subject_id, student_id) VALUES (5.2, 2, 102);  -- Physics
INSERT INTO grades (grade, subject_id, student_id) VALUES (4.9, 3, 102);  -- Chemistry
INSERT INTO grades (grade, subject_id, student_id) VALUES (3.5, 4, 102);  -- Biology
INSERT INTO grades (grade, subject_id, student_id) VALUES (4.1, 5, 102);  -- History
INSERT INTO grades (grade, subject_id, student_id) VALUES (5.0, 6, 102);  -- Geography
INSERT INTO grades (grade, subject_id, student_id) VALUES (4.7, 7, 102);  -- English
INSERT INTO grades (grade, subject_id, student_id) VALUES (5.5, 8, 102);  -- PE
INSERT INTO grades (grade, subject_id, student_id) VALUES (3.0, 9, 102);  -- CS
INSERT INTO grades (grade, subject_id, student_id) VALUES (4.6, 10, 102); -- Art


-- IMPORTANT: After explicit ID inserts, reset the sequence for future auto-generated IDs
SELECT setval('subjects_id_seq', (SELECT MAX(id) FROM subjects), true);
SELECT setval('students_id_seq', (SELECT MAX(id) FROM students), true);
SELECT setval('grades_id_seq', (SELECT MAX(id) FROM grades), true); -- CORRECTED: Sequence for the 'grades' table