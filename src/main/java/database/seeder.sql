use adlister_db;

insert into users (username, email, password) values
('Emmanuel Goldstein', 'C3r3al_K1ll3r@hacker.com', '2105551111'),
('Paul Cook', 'L0rd_N1kk0n@hacker.com', '2105552222');

insert into ads (users_id, title, description) values
(1, 'playstation for sale', 'This is a slightly used playstation'),
(1, 'Super Nintendo', 'Get your game on with this old-school classic!'),
(2, 'Junior Java Developer Position', 'Minimum 7 years of experience required. You will be working in the scripting language for Java, JavaScript'),
(2, 'JavaScript Developer needed', 'Must have strong Java skills');