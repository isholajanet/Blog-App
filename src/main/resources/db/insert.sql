set foreign_key_checks = 0;

truncate table article;
insert into article(`id`, `title`,`description`, `image_url`)
values(123, "my first article", "this is my first article", "https://www.google.com"),
       (124, "My second article", "this is my second article", "https://twitter.com");

set foreign_key_checks = 1;
