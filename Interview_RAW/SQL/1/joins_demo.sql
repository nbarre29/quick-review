-- ============================================================
--  MySQL Demo Script: INNER JOIN vs LEFT JOIN
--  Includes: database, tables, sample data, and queries
-- ============================================================

-- 1. CREATE & USE DATABASE
-- ============================================================
DROP DATABASE IF EXISTS joins_demo;
CREATE DATABASE joins_demo;
USE joins_demo;


-- 2. CREATE TABLES
-- ============================================================

CREATE TABLE departments (
    id              INT           PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(100)  NOT NULL,
    location        VARCHAR(100)
);

CREATE TABLE employees (
    id         INT          PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(100) NOT NULL,
    email      VARCHAR(150),
    salary     DECIMAL(10,2),
    dept_id    INT,                          -- nullable = no department
    FOREIGN KEY (dept_id) REFERENCES departments(id)
);


-- 3. INSERT SAMPLE DATA
-- ============================================================

INSERT INTO departments (department_name, location) VALUES
    ('Engineering',  'New York'),
    ('Marketing',    'Los Angeles'),
    ('HR',           'Chicago'),
    ('Finance',      'Houston');
    -- Note: "Design" dept intentionally omitted — no matching employees

INSERT INTO employees (name, email, salary, dept_id) VALUES
    ('Alice Johnson',  'alice@company.com',   95000.00, 1),   -- Engineering
    ('Bob Smith',      'bob@company.com',     72000.00, 2),   -- Marketing
    ('Carol White',    'carol@company.com',   68000.00, 2),   -- Marketing
    ('David Brown',    'david@company.com',   85000.00, 1),   -- Engineering
    ('Eva Martinez',   'eva@company.com',     61000.00, 3),   -- HR
    ('Frank Lee',      'frank@company.com',   91000.00, 1),   -- Engineering
    ('Grace Kim',      'grace@company.com',   77000.00, 4),   -- Finance
    ('Henry Wilson',   'henry@company.com',   55000.00, NULL),-- NO department
    ('Irene Adams',    'irene@company.com',   62000.00, NULL);-- NO department


-- ============================================================
-- 4. QUERIES
-- ============================================================


-- ── Query 1: INNER JOIN ──────────────────────────────────────
-- Returns only employees who belong to a department
-- (Henry and Irene are excluded)
-- ────────────────────────────────────────────────────────────
SELECT
    e.id,
    e.name          AS employee_name,
    e.salary,
    d.department_name,
    d.location
FROM employees e
INNER JOIN departments d ON e.dept_id = d.id
ORDER BY d.department_name, e.name;


-- ── Query 2: LEFT JOIN ───────────────────────────────────────
-- Returns ALL employees; unassigned ones show NULL for dept info
-- ────────────────────────────────────────────────────────────
SELECT
    e.id,
    e.name              AS employee_name,
    e.salary,
    COALESCE(d.department_name, 'No Department') AS department_name,
    COALESCE(d.location,        'N/A')           AS location
FROM employees e
LEFT JOIN departments d ON e.dept_id = d.id
ORDER BY department_name, e.name;


-- ── Query 3: Find employees WITHOUT a department ─────────────
-- Classic LEFT JOIN + NULL check pattern
-- ────────────────────────────────────────────────────────────
SELECT
    e.id,
    e.name  AS employee_name,
    e.email
FROM employees e
LEFT JOIN departments d ON e.dept_id = d.id
WHERE d.id IS NULL;


-- ── Query 4: Find departments with NO employees ──────────────
-- Reverse LEFT JOIN (departments is now the left table)
-- ────────────────────────────────────────────────────────────
SELECT
    d.id,
    d.department_name,
    d.location
FROM departments d
LEFT JOIN employees e ON d.id = e.dept_id
WHERE e.id IS NULL;


-- ── Query 5: Department summary (headcount + avg salary) ─────
-- INNER JOIN + GROUP BY aggregation
-- ────────────────────────────────────────────────────────────
SELECT
    d.department_name,
    COUNT(e.id)        AS headcount,
    AVG(e.salary)      AS avg_salary,
    MAX(e.salary)      AS top_salary,
    MIN(e.salary)      AS lowest_salary
FROM departments d
INNER JOIN employees e ON d.id = e.dept_id
GROUP BY d.id, d.department_name
ORDER BY avg_salary DESC;


-- ── Query 6: All departments including empty ones ────────────
-- LEFT JOIN + GROUP BY to include departments with 0 employees
-- ────────────────────────────────────────────────────────────
SELECT
    d.department_name,
    COUNT(e.id)        AS headcount,
    COALESCE(AVG(e.salary), 0) AS avg_salary
FROM departments d
LEFT JOIN employees e ON d.id = e.dept_id
GROUP BY d.id, d.department_name
ORDER BY headcount DESC;


-- ── Query 7: Side-by-side comparison (INNER vs LEFT count) ───
SELECT
    'INNER JOIN' AS join_type,
    COUNT(*)     AS rows_returned
FROM employees e
INNER JOIN departments d ON e.dept_id = d.id

UNION ALL

SELECT
    'LEFT JOIN',
    COUNT(*)
FROM employees e
LEFT JOIN departments d ON e.dept_id = d.id;


-- ============================================================
-- END OF SCRIPT
-- ============================================================
