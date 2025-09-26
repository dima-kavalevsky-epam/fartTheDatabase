INSERT INTO users (id, name, surname, birth_date, email) VALUES
(1, 'John', 'Doe', '1990-05-15', 'john.doe@example.com'),
(2, 'Jane', 'Smith', '1985-08-20', 'jane.smith@example.com'),
(3, 'Michael', 'Johnson', '1992-03-10', 'michael.johnson@example.com'),
(4, 'Emily', 'Brown', '1988-11-25', 'emily.brown@example.com');

-- Insert sample card info
INSERT INTO card_info (id, user_id, number, holder, expiration_date) VALUES
(1, 1, '1234567812345678', 'JOHN DOE', '2025-12-31'),
(2, 1, '8765432187654321', 'JOHN DOE', '2024-06-30'),
(3, 2, '1111222233334444', 'JANE SMITH', '2026-03-15'),
(4, 3, '5555666677778888', 'MICHAEL JOHNSON', '2025-09-20'),
(5, 4, '9999000011112222', 'EMILY BROWN', '2024-12-25');