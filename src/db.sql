insert into lc_shop (id, name, display_name, description, max_cashback, url, logo_url)
values
    (1, 'bse', 'Best Shop Ever', 'От диванов до пельменей', 5, '/bse', '/img/bse_logo.svg');

insert into bse_product (name, picture_url, price, cashback_percent)
values
    ('Ручка шариковая', '/img/products/pen.png', 19, 5),
    ('Пельмени замороженные развесные 1кг', '/img/products/pelmeni.png', 280, 4),
    ('Унитаз-компакт с горизонтальным выпуском', '/img/products/toilet.png', 12180, 3.7),
    ('Диван угловой', '/img/products/sofa.png', 41800, 2),
    ('Телевизор жидкокристаллический', '/img/products/tv.png', 189990, 0.5);

