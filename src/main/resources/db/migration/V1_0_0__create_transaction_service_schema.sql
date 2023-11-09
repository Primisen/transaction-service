CREATE TABLE IF NOT EXISTS account
(
    id                 SERIAL PRIMARY KEY,
    balance            FLOAT                    NOT NULL,
    currency_shortname VARCHAR(5) DEFAULT 'USD' NOT NULL
);

CREATE TABLE IF NOT EXISTS limits
(
    id                 SERIAL PRIMARY KEY,
    account_id         INT                      NOT NULL,
    sum                FLOAT                    NOT NULL,
    datetime           TIMESTAMP                NOT NULL,
    currency_shortname VARCHAR(5) DEFAULT 'USD' NOT NULL,
    expense_category   VARCHAR(15)              NOT NULL,

    FOREIGN KEY (account_id) REFERENCES account (id)
);

CREATE TABLE IF NOT EXISTS transaction
(
    id                 SERIAL PRIMARY KEY,
    account_from_id    INT         NOT NULL,
    account_to_id      INT         NOT NULL,
    currency_shortname VARCHAR(5)  NOT NULL,
    limit_exceeded     BOOLEAN     NOT NULL,
    sum                FLOAT       NOT NULL,
    datetime           TIMESTAMP   NOT NULL,
    expense_category   VARCHAR(15) NOT NULL,

    FOREIGN KEY (account_from_id) REFERENCES account (id),
    FOREIGN KEY (account_to_id) REFERENCES account (id)
);
