
-- =============================
-- Create machines table
-- =============================
CREATE TABLE machines (
    machine_id BIGINT PRIMARY KEY,
    name VARCHAR(100),
    location VARCHAR(150),
    last_maintenance_date DATE,
    maintenance_interval_days INT,
    status VARCHAR(50)
);

-- =============================
-- Create machine_tasks table
-- =============================
CREATE TABLE machine_tasks (
    task_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    machine_id BIGINT,
    task_description VARCHAR(255),
    scheduled_date DATE,
    status VARCHAR(50),
    completed_on DATE,
    FOREIGN KEY (machine_id) REFERENCES machines(machine_id)
);

-- =============================
-- Insert machines
-- =============================
INSERT INTO machines VALUES
(1,'Press 101','Plant 1 - Section A','2025-01-12',30,'Operational'),
(2,'Press 102','Plant 1 - Section A','2025-09-15',30,'Needs Maintenance'),
(3,'Conveyor Line 3','Plant 2 - Packaging Area','2025-12-20',7,'Operational'),
(4,'Pump X7','Plant 1 - Basement','2025-06-01',90,'Under Maintenance'),
(5,'Generator G1','Plant 2 - Power Room','2025-07-01',180,'Operational');

-- =============================
-- Insert machine tasks
-- =============================
INSERT INTO machine_tasks (machine_id, task_description, scheduled_date, status, completed_on)
VALUES
(1, 'Oil Change', '2026-03-01', 'Scheduled', NULL),
(3, 'Belt Inspection', '2026-02-25', 'Scheduled', NULL),
(2, 'Pressure Calibration', '2026-02-28', 'Scheduled', NULL),
(1, 'Oil Lubrication', '2025-02-10', 'Pending', NULL),
(1, 'Safety Inspection', '2025-02-15', 'Pending', NULL),
(2, 'Hydraulic Check', '2025-10-10', 'Scheduled', NULL),
(3, 'Belt Alignment', '2025-12-25', 'Scheduled', NULL),
(4, 'Motor Calibration', '2025-08-25', 'Pending', NULL),
(5, 'Power System Review', '2025-12-20', 'Scheduled', NULL);
