CREATE TABLE IF NOT EXISTS books(
    ISBN varbinary(16) primary key not null,
    title varchar(50) not null,
    edition INTEGER,
    author varbinary(16)
);