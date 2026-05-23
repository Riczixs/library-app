INSERT INTO books(ISBN, title, edition, author)
VALUES
    (uuid_to_bin('c582da13-79a9-4948-a795-a6995f8913b9'), 'The Lord of the Rings: The Fellowship of the Ring', 1, uuid_to_bin('406dc0f4-7b0a-48ae-afc7-1b44532c2786')),
    (uuid_to_bin('e3f70f8b-0d5a-4767-a26b-42c63ab7d622'), 'A Wizard of Earthsea', 2, uuid_to_bin('f9761463-4f4c-4a58-9d6e-be1daa4a5077')),
    (uuid_to_bin('e4196393-6c46-4c2e-8b21-2a9e7c5b1c3d'), 'Diune', 3, uuid_to_bin('c582da13-79a9-4948-a795-a6995f8913b9'))