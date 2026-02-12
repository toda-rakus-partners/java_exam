問1：
INSERT INTO items (id, category_id, name, price) VALUES (13, 1, '鰯', 150);
INSERT INTO items (id, category_id, name, price) VALUES (14, 2, '羊', 650);

問2：
UPDATE items SET price = price * 0.9 ;

問3：
DELETE FROM employees WHERE end_date < '2013-04-01';

問4：
-- 解き直し
SELECT * FROM employees WHERE end_date = 'null' ORDER BY start_date;

問5：
SELECT r.name AS 地域名, p.name AS 都道府県名 FROM prefectures p JOIN regions r ON r.code = p.region_code;

問6：
SELECT sum(population) AS population FROM populations;

問7：
SELECT p.name AS prefecture, g.name AS gender, sum(po.population) AS population
FROM populations po 
JOIN prefectures p ON p.code = po.prefecture_code 
JOIN genders g ON g.code = po.gender_code
WHERE p.name = '福岡県' OR p.name = '宮崎県' OR p.name = '佐賀県' OR p.name = '長崎県' OR p.name = '熊本県' OR p.name = '大分県' OR p.name = '鹿児島県'OR p.name = '沖縄県'
GROUP BY p.name, g.name;
