CREATE TABLE IF NOT EXISTS books(
    ISBN varbinary(16) primary key not null,
    title varchar(100) not null,
    edition INTEGER,
    author varbinary(16)
);