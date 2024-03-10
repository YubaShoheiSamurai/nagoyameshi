-- restaurantsテーブル
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (1, '炭火やきとり マメ', 'yakitori01.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 2000, 4000, '396-3825', '秋田県 高橋市宇野町佐々木3-4-4 ハイツ渚102号', '2:30', '10:30', 147);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (2, '大衆焼肉酒場 ホルモン屋 栄店', 'yakiniku01.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 8500, 10000, '368-7361', '神奈川県 大垣市藤本町廣川4-1-3 コーポ原田103号', '2:30', '10:30', 66);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (3, '魚と野菜と酒 じゃばらむ', 'sakana.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 3500, 5500, '523-6344', '三重県 井上市山口町高橋6-10-5 ハイツ坂本110号', '10:30', '18:30', 88);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (4, 'ちょもちょもらん', 'yakiniku02.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 6500, 8500, '123-4567', '愛知県名古屋市中区栄X-XX-XX', '9:00', '18:00', 77);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (5, '台湾ラーメン 田中 守山本店', 'ramen02.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 500, 1000, '123-4567', '愛知県名古屋市中区栄X-XX-XX', '7:30', '17:30', 43);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (6, '割烹 加藤	', 'oden.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 1000, 4000, '123-4567', '愛知県名古屋市中区栄X-XX-XX', '8:00', '17:30', 6);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (7, '炭火串焼コケッコ屋 半田店', 'yakitori02.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 1500, 5000, '111-1111', '愛知県名古屋市中区栄X-XX-XX', '7:30', '15:00', 7);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (8, 'やきにく 山崎', 'yakiniku03.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 2000, 8500, '123-456', '愛知県名古屋市中区栄X-XX-XX', '6:30', '9:00', 12);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (9, 'NAGOYA BURGER 名駅店', 'burger.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 1500, 3500, '204-4168', '和歌山県 三宅市山本町加藤2-10-5 ハイツ井上101号', '6:30', '14:30', 77);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (10, 'つけ麺MENMARU', 'tsukemen.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 2000, 4000, '505-7772', '大分県 木村市山田町高橋7-7-5 コーポ佐藤103号', '12:30', '20:30', 140);

-- rolesテーブル
INSERT IGNORE INTO roles (id, name) VALUES (1, 'ROLE_FREE_MEMBER');
INSERT IGNORE INTO roles (id, name) VALUES (2, 'ROLE_PAID_MEMBER');
INSERT IGNORE INTO roles (id, name) VALUES (3, 'ROLE_ADMIN');

-- usersテーブル
INSERT IGNORE INTO users (id, name, furigana, sex, birthday, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (1, '侍 太郎', 'サムライ タロウ', 1, '1989-01-01', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'taro.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 1, true);
INSERT IGNORE INTO users (id, name, furigana, sex, birthday, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (2, '侍 花子', 'サムライ ハナコ', 2, '1970-03-11', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'hanako.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 3, true);
INSERT IGNORE INTO users (id, name, furigana, sex, birthday, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (3, '侍 三郎', 'サムライ サブロウ', 1, '1968-01-01', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'saburou.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 1, true);
INSERT IGNORE INTO users (id, name, furigana, sex, birthday, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (4, '侍 四郎', 'サムライ シロウ', 1, '2000-01-01', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'shirou.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 1, true);

-- reservationsテーブル
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_datetime, number_of_people) VALUES (1, 1, 1, '2023-04-01 09:30:00', 2);
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_datetime, number_of_people) VALUES (2, 2, 1, '2023-04-01 14:30:00', 3);
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_datetime, number_of_people) VALUES (3, 3, 1, '2023-04-01 15:30:00', 4);
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_datetime, number_of_people) VALUES (4, 4, 1, '2023-04-01 08:30:00', 5);
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_datetime, number_of_people) VALUES (5, 5, 1, '2023-04-01 17:30', 6);
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_datetime, number_of_people) VALUES (6, 6, 1, '2023-04-01 12:30', 2);
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_datetime, number_of_people) VALUES (7, 7, 1, '2023-04-01 12:30', 3);
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_datetime, number_of_people) VALUES (8, 8, 1, '2023-04-01 12:30', 4);
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_datetime, number_of_people) VALUES (9, 9, 1, '2023-04-01 12:30', 5);
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_datetime, number_of_people) VALUES (10, 10, 1, '2023-04-01 07:30', 6);

-- reviewsテーブル
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (1, 1, 4, 4, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (2, 1, 3, 5, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (3, 2, 4, 1, '微妙でした');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (4, 2, 3, 3, '良かったです');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (5, 3, 4, 3, '良かったです');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (6, 3, 3, 2, '微妙でした');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (7, 4, 4, 5, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (8, 4, 3, 5, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (9, 5, 4, 2, '微妙でした');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (10, 5, 3, 5, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (11, 6, 4, 3, '良かったです');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (12, 6, 3, 4, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (13, 7, 4, 1, '微妙でした');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (14, 7, 3, 5, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (15, 8, 4, 2, '微妙でした');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (16, 8, 3, 4, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (17, 9, 4, 4, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (18, 9, 3, 5, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (19, 10, 4, 4, 'すごく良かったです');
INSERT IGNORE INTO reviews (id, restaurant_id, user_id, review, comment) VALUES (20, 10, 3, 5, 'すごく良かったです');

-- categoriesテーブル
INSERT IGNORE INTO categories (id, name) VALUES (1, '居酒屋');
INSERT IGNORE INTO categories (id, name) VALUES (2, '焼肉');
INSERT IGNORE INTO categories (id, name) VALUES (4, '定食');
INSERT IGNORE INTO categories (id, name) VALUES (5, 'カレー');
INSERT IGNORE INTO categories (id, name) VALUES (6, '喫茶店');
INSERT IGNORE INTO categories (id, name) VALUES (7, '中華料理');
INSERT IGNORE INTO categories (id, name) VALUES (8, 'イタリア料理');
INSERT IGNORE INTO categories (id, name) VALUES (9, 'フランス料理');
INSERT IGNORE INTO categories (id, name) VALUES (10, 'スペイン料理');
INSERT IGNORE INTO categories (id, name) VALUES (11, '韓国料理');
INSERT IGNORE INTO categories (id, name) VALUES (12, 'タイ料理');
INSERT IGNORE INTO categories (id, name) VALUES (13, '海鮮料理');
INSERT IGNORE INTO categories (id, name) VALUES (14, 'ステーキ');
INSERT IGNORE INTO categories (id, name) VALUES (15, 'ハンバーグ');
INSERT IGNORE INTO categories (id, name) VALUES (16, 'ハンバーガー');
INSERT IGNORE INTO categories (id, name) VALUES (17, 'そば');
INSERT IGNORE INTO categories (id, name) VALUES (18, 'お好み焼き');
INSERT IGNORE INTO categories (id, name) VALUES (19, 'たこ焼き');
INSERT IGNORE INTO categories (id, name) VALUES (20, '鍋料理');
INSERT IGNORE INTO categories (id, name) VALUES (21, 'バー');
INSERT IGNORE INTO categories (id, name) VALUES (22, 'パン');
INSERT IGNORE INTO categories (id, name) VALUES (23, 'スイーツ');
INSERT IGNORE INTO categories (id, name) VALUES (24, '焼き鳥');
INSERT IGNORE INTO categories (id, name) VALUES (25, 'すき焼き');
INSERT IGNORE INTO categories (id, name) VALUES (26, 'しゃぶしゃぶ');
INSERT IGNORE INTO categories (id, name) VALUES (27, '天ぷら');
INSERT IGNORE INTO categories (id, name) VALUES (28, '鉄板焼き');
INSERT IGNORE INTO categories (id, name) VALUES (29, '和食');
INSERT IGNORE INTO categories (id, name) VALUES (30, 'うどん');
INSERT IGNORE INTO categories (id, name) VALUES (31, '丼物');
INSERT IGNORE INTO categories (id, name) VALUES (32, 'ラーメン');
INSERT IGNORE INTO categories (id, name) VALUES (33, 'おでん');
INSERT IGNORE INTO categories (id, name) VALUES (34, '揚げ物');

-- regularsテーブル
INSERT IGNORE INTO regulars (id, restaurant_id, holiday) VALUES (1, 1, 0);
INSERT IGNORE INTO regulars (id, restaurant_id, holiday) VALUES (2, 1, 6);
INSERT IGNORE INTO regulars (id, restaurant_id, holiday) VALUES (3, 2, 1);
INSERT IGNORE INTO regulars (id, restaurant_id, holiday) VALUES (4, 2, 2);
INSERT IGNORE INTO regulars (id, restaurant_id, holiday) VALUES (5, 3, 1);
INSERT IGNORE INTO regulars (id, restaurant_id, holiday) VALUES (6, 4, 0);
INSERT IGNORE INTO regulars (id, restaurant_id, holiday) VALUES (7, 4, 6);
INSERT IGNORE INTO regulars (id, restaurant_id, holiday) VALUES (8, 5, 1);
INSERT IGNORE INTO regulars (id, restaurant_id, holiday) VALUES (9, 5, 5);
INSERT IGNORE INTO regulars (id, restaurant_id, holiday) VALUES (10, 6, 1);
INSERT IGNORE INTO regulars (id, restaurant_id, holiday) VALUES (11, 7, 1);
INSERT IGNORE INTO regulars (id, restaurant_id, holiday) VALUES (12, 8, 0);
INSERT IGNORE INTO regulars (id, restaurant_id, holiday) VALUES (13, 8, 6);
INSERT IGNORE INTO regulars (id, restaurant_id, holiday) VALUES (14, 9, 0);
INSERT IGNORE INTO regulars (id, restaurant_id, holiday) VALUES (15, 9, 6);
INSERT IGNORE INTO regulars (id, restaurant_id, holiday) VALUES (16, 10, 0);
INSERT IGNORE INTO regulars (id, restaurant_id, holiday) VALUES (17, 10, 6);

-- restaurant_categoryテーブル
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (1, 1, 1);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (2, 1, 24);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (3, 2, 1);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (4, 2, 3);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (5, 3, 1);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (6, 3, 2);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (7, 3, 3);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (8, 3, 29);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (9, 4, 2);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (10, 5, 7);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (11, 5,32);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (12, 6, 1);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (13, 6, 29);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (14, 6, 33);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (15, 7, 4);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (16, 7, 24);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (17, 7, 29);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (18, 7, 34);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (19, 8, 2);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (20, 9, 16);
INSERT IGNORE INTO restaurant_category (id, restaurant_id, category_id) VALUES (21, 10, 32);