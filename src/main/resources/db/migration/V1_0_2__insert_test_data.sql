INSERT INTO limits(account_id, sum, datetime, currency_shortname, expense_category) VALUES (1, 1000, '2023-11-13 09:38:55.484000 +00:00', 'USD', 'PRODUCT');
INSERT INTO limits(account_id, sum, datetime, currency_shortname, expense_category) VALUES (1, 1000, '2023-11-13 09:38:55.484000 +00:00', 'USD', 'SERVICE');

INSERT INTO limits(account_id, sum, datetime, currency_shortname, expense_category) VALUES (2, 1000, '2023-11-13 09:38:55.484000 +00:00', 'USD', 'PRODUCT');
INSERT INTO limits(account_id, sum, datetime, currency_shortname, expense_category) VALUES (2, 1000, '2023-11-13 09:38:55.484000 +00:00', 'USD', 'SERVICE');

INSERT INTO account (balance, currency_shortname) VALUES (1500, 'USD');
INSERT INTO limits(account_id, sum, datetime, currency_shortname, expense_category) VALUES (3, 1000, '2023-11-13 09:38:55.484000 +00:00', 'USD', 'PRODUCT');
INSERT INTO limits(account_id, sum, datetime, currency_shortname, expense_category) VALUES (3, 1000, '2023-11-13 09:38:55.484000 +00:00', 'USD', 'SERVICE');

INSERT INTO transaction (account_from_id, account_to_id, currency_shortname, limit_exceeded, sum, datetime, expense_category, limit_exceeded_id)
VALUES (1, 2, 'USD', true, 1005.00, '2023-11-13 09:38:55.484000 +00:00', 'SERVICE', 2);