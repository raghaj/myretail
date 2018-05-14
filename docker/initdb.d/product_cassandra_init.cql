DROP KEYSPACE IF EXISTS product_api;

CREATE KEYSPACE product_api
    WITH replication = {'class':'SimpleStrategy', 'replication_factor':1} AND durable_writes = true;

USE product_api;

CREATE TABLE IF NOT EXISTS product_api.product_price(
    id TEXT,
    data TEXT,
    PRIMARY KEY(id)
) ;

INSERT INTO product_api.product_price (id, data) VALUES ('13860428', '{ "id":13860428, current_price":{"value": 13.49,  "currency_code":"USD"} }');
