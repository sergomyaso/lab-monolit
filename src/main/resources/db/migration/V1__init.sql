CREATE TABLE clients
(
    "id"         serial PRIMARY KEY NOT NULL,
    "firstName"  TEXT               NOT NULL,
    "secondName" TEXT               NOT NULL,
    "lastName"   TEXT               NOT NULL,
    "passport"   TEXT               NOT NULL
);

CREATE TABLE cards
(
    "id"         serial PRIMARY KEY NOT NULL,
    "clientId"   INTEGER            NOT NULL,
    "cardNumber" TEXT               NOT NULL,
    "expiredAt"  TIMESTAMP          NOT NULL,
    "cardType"   TEXT               NOT NULL,

    CONSTRAINT fk_cards_clients FOREIGN KEY ("clientId") REFERENCES clients (id)
);

CREATE TABLE credits
(
    "id"       serial PRIMARY KEY NOT NULL,
    "clientId" INTEGER            NOT NULL,
    "summary"  FLOAT              NOT NULL,
    "percent"  FLOAT              NOT NULL,
    "payDay"   INTEGER            NOT NULL,

    CONSTRAINT fk_credits_clients FOREIGN KEY ("clientId") REFERENCES clients (id)
);

@TODO: доделать депозиты
CREATE TABLE credits
(
    "id"       serial PRIMARY KEY NOT NULL,
    "clientId" INTEGER            NOT NULL,
    "summary"  FLOAT              NOT NULL,
    "percent"  FLOAT              NOT NULL,
    "payDay"   INTEGER            NOT NULL,

    CONSTRAINT fk_credits_clients FOREIGN KEY ("clientId") REFERENCES clients (id)
);