INSERT INTO pizzas (`name`, description, photo, price) VALUES('Margherita', 'mozzarella,pomodoro', 'https://www.finedininglovers.it/sites/g/files/xknfdk1106/files/fdl_content_import_it/margherita-50kalo.jpg', 5);
INSERT INTO pizzas (`name`, description, photo, price) VALUES('Marinara', 'pomodoro,origano', 'https://img.delicious.com.au/qRrzAHSr/del/2019/03/marinara-pizza-102752-2.jpg', 4);

INSERT INTO offerte (pizza_id, title, start_date, end_date) VALUES(1,'Offerta di San valentino', '2024-01-15', '2024-06-30');
INSERT INTO offerte (pizza_id, title, start_date, end_date) VALUES(1, 'Offerta di Natale', '2024-12-25', '2025-01-01');

INSERT INTO pizza_type (name) VALUES('Baby');
INSERT INTO pizza_type (name) VALUES('A ruota di carro');
INSERT INTO pizza_type (name) VALUES('Normale');