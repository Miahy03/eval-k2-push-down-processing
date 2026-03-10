CREATE TABLE car_models (
    id SERIAL PRIMARY KEY,
    brand VARCHAR(20) NOT NULL CHECK (brand IN ('KIA', 'HYUNDAI', 'DAEWOO')),
    model VARCHAR(20) NOT NULL CHECK (model IN ('GETZ', 'PRIDE', 'LACETTI'))
);

CREATE TABLE car_parts (
    id SERIAL PRIMARY KEY,
    car_model_id INT NOT NULL REFERENCES car_models(id) ON DELETE CASCADE,
    serial_number VARCHAR(50) UNIQUE NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

CREATE TABLE sales (
    id SERIAL PRIMARY KEY,
    car_part_id INT NOT NULL REFERENCES car_parts(id) ON DELETE CASCADE,
    quantity INT NOT NULL CHECK (quantity > 0)
);