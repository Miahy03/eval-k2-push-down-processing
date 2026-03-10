INSERT INTO car_models (brand, model) VALUES
('KIA', 'PRIDE'),
('HYUNDAI', 'GETZ'),
('DAEWOO', 'LACETTI');

INSERT INTO car_parts (car_model_id, serial_number, price) VALUES
(1, 'SN-KIA-001', 120.50),
(1, 'SN-KIA-002', 75.00),
(2, 'SN-HY-001', 95.99),
(3, 'SN-DAE-001', 150.00),
(3, 'SN-DAE-002', 200.00);

INSERT INTO sales (car_part_id, quantity) VALUES
(1, 2),
(2, 5),
(3, 1),
(4, 3),
(5, 2);