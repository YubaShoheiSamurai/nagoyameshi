-- テーブル
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (1, '炭火やきとり マメ', 'yakitori01.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 2000, 4000, '396-3825', '秋田県 高橋市宇野町佐々木3-4-4 ハイツ渚102号', '2:30', '10:30', 147);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (2, 'ノイナイアー', 'dummy.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 8000, 10000, '461-8504', '石川県 青田市中島町坂本9-8-9 コーポ青田109号', '8:30', '16:30', 143);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (3, 'エチェバリア', 'dummy.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 9000, 11000, '448-2552', '神奈川県 渚市坂本町加藤2-9-1 コーポ鈴木108号', '9:30', '17:30', 41);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (4, '大衆焼肉酒場 ホルモン屋 栄店', 'yakiniku01.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 8500, 10000, '368-7361', '神奈川県 大垣市藤本町廣川4-1-3 コーポ原田103号', '2:30', '10:30', 66);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (5, '魚と野菜と酒 じゃばらむ', 'sakana.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 3500, 5500, '523-6344', '三重県 井上市山口町高橋6-10-5 ハイツ坂本110号', '10:30', '18:30', 88);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (6, 'ちょもちょもらん', 'yakiniku02.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 6500, 8500, '123-4567', '愛知県名古屋市中区栄X-XX-XX', '9:00', '18:00', 77);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (7, '台湾ラーメン 田中 守山本店', 'ramen02.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 500, 1000, '123-4567', '愛知県名古屋市中区栄X-XX-XX', '7:30', '17:30', 43);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (8, '割烹 加藤	', 'oden.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 1000, 4000, '123-4567', '愛知県名古屋市中区栄X-XX-XX', '8:00', '17:30', 6);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (9, '炭火串焼コケッコ屋 半田店', 'yakitori02.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 1500, 5000, '111-1111', '愛知県名古屋市中区栄X-XX-XX', '7:30', '15:00', 7);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (10, 'やきにく 山崎', 'yakiniku03.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 2000, 8500, '123-456', '愛知県名古屋市中区栄X-XX-XX', '6:30', '9:00', 12);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (11, 'NAGOYA BURGER 名駅店', 'burger.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 1500, 3500, '204-4168', '和歌山県 三宅市山本町加藤2-10-5 ハイツ井上101号', '6:30', '14:30', 77);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (12, 'つけ麺MENMARU', 'tsukemen.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 2000, 4000, '505-7772', '大分県 木村市山田町高橋7-7-5 コーポ佐藤103号', '12:30', '20:30', 140);
INSERT IGNORE INTO restaurants (id, name, image_name, description, low_price, high_price, postal_code, address, opening_time, closed_time, seating_capacity) VALUES (13, 'ゲッテマレシ', 'dummy.jpg', '名古屋老舗のお店。老舗の味をご堪能ください。', 7000, 9000, '912-7407', '茨城県 田中市吉田町宮沢1-4-8 ハイツ青田103号', '1:30', '9:30', 142);

-- rolesテーブル
INSERT IGNORE INTO roles (id, name) VALUES (1, 'ROLE_FREE_MEMBER');
INSERT IGNORE INTO roles (id, name) VALUES (2, 'ROLE_ADMIN');
INSERT IGNORE INTO roles (id, name) VALUES (3, 'ROLE_PAID_MEMBER');

-- usersテーブル
INSERT IGNORE INTO users (id, name, furigana, sex, birthday, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (1, '侍 太郎', 'サムライ タロウ', 1, '1989-01-01', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'taro.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 1, true);
INSERT IGNORE INTO users (id, name, furigana, sex, birthday, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (2, '侍 花子', 'サムライ ハナコ', 2, '1970-03-11', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'hanako.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 2, true);
INSERT IGNORE INTO users (id, name, furigana, sex, birthday, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (3, '侍 義勝', 'サムライ ヨシカツ', 1, '1968-11-21', '638-0644', '奈良県五條市西吉野町湯川X-XX-XX', '090-1234-5678', 'yoshikatsu.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, sex, birthday, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (4, '侍 幸美', 'サムライ サチミ', 2, '1989-11-21', '342-0006', '埼玉県吉川市南広島X-XX-XX', '090-1234-5678', 'sachimi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, sex, birthday, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (5, '侍 雅', 'サムライ ミヤビ', 2, '1998-01-11', '527-0209', '滋賀県東近江市佐目町X-XX-XX', '090-1234-5678', 'miyabi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, sex, birthday, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (6, '侍 正保', 'サムライ マサヤス', 1, '1989-01-01', '989-1203', '宮城県柴田郡大河原町旭町X-XX-XX', '090-1234-5678', 'masayasu.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, sex, birthday, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (7, '侍 真由美', 'サムライ マユミ', 2, '1989-01-01', '951-8015', '新潟県新潟市松岡町X-XX-XX', '090-1234-5678', 'mayumi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, sex, birthday, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (8, '侍 安民', 'サムライ ヤスタミ', 1, '1989-01-01', '241-0033', '神奈川県横浜市旭区今川町X-XX-XX', '090-1234-5678', 'yasutami.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, sex, birthday, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (9, '侍 章緒', 'サムライ アキオ', 1, '1989-01-01', '739-2103', '広島県東広島市高屋町宮領X-XX-XX', '090-1234-5678', 'akio.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, sex, birthday, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (10, '侍 祐子', 'サムライ ユウコ', 2, '1989-01-01', '601-0761', '京都府南丹市美山町高野X-XX-XX', '090-1234-5678', 'yuko.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, sex, birthday, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (11, '侍 秋美', 'サムライ アキミ', 2, '1989-01-01', '606-8235', '京都府京都市左京区田中西春菜町X-XX-XX', '090-1234-5678', 'akimi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, sex, birthday, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (12, '侍 信平', 'サムライ シンペイ', 1, '1989-01-01', '673-1324', '兵庫県加東市新定X-XX-XX', '090-1234-5678', 'shinpei.samurai@example.com', 'password', 1, false);

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
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reservation_datetime, number_of_people) VALUES (11, 11, 1, '2023-04-01 12:30', 2);