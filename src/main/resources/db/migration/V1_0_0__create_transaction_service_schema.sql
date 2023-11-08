CREATE TABLE IF NOT EXISTS currency_shortname
(
    id        SERIAL PRIMARY KEY,
    shortname VARCHAR(5) NOT NULL
);

CREATE TABLE IF NOT EXISTS expense_category
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS account
(
    id                    SERIAL PRIMARY KEY,
    number                INT   NOT NULL,
    balance               FLOAT NOT NULL,
    currency_shortname_id INT   NOT NULL,

    FOREIGN KEY (currency_shortname_id) REFERENCES currency_shortname (id)
);

CREATE TABLE IF NOT EXISTS limits
(
    id                    SERIAL PRIMARY KEY,
    account_id            INT       NOT NULL,
    sum                   FLOAT     NOT NULL,
    datetime              TIMESTAMP NOT NULL,
    currency_shortname_id INT       NOT NULL,
    expense_category_id   INT       NOT NULL,

    FOREIGN KEY (account_id) REFERENCES account (id),
    FOREIGN KEY (currency_shortname_id) REFERENCES currency_shortname (id),
    FOREIGN KEY (expense_category_id) REFERENCES expense_category (id)
);

CREATE TABLE IF NOT EXISTS transaction
(
    id                    SERIAL PRIMARY KEY,
    account_from_id       INT       NOT NULL,
    account_to_id         INT       NOT NULL,
    currency_shortname_id INT       NOT NULL,
    limit_exceeded        BOOLEAN   NOT NULL,
    sum                   FLOAT     NOT NULL,
    datetime              TIMESTAMP NOT NULL,
    expense_category_id   INT       NOT NULL,

    FOREIGN KEY (account_from_id) REFERENCES account (id),
    FOREIGN KEY (account_to_id) REFERENCES account (id),
    FOREIGN KEY (currency_shortname_id) REFERENCES currency_shortname (id),
    FOREIGN KEY (expense_category_id) REFERENCES expense_category (id)
);
