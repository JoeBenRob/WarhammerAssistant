INSERT INTO USER (id, name, score) VALUES (1	, 'Jack'	, 0	)
INSERT INTO USER (id, name, score) VALUES (2	, 'Joe'		, 0	)
INSERT INTO USER (id, name, score) VALUES (3	, 'James'	, 0	)
INSERT INTO USER (id, name, score) VALUES (4	, 'Aysha'	, 0	)
INSERT INTO USER (id, name, score) VALUES (5	, 'Lucy'	, 0	)

INSERT INTO UNIT (id, name, army, allegiance, min, max, points) VALUES (1, 'Saurus Warrior'	, 'Seraphon'	, 'Order'	, 10	, 40	, 100	)
INSERT INTO UNIT (id, name, army, allegiance, min, max, points) VALUES (2, 'Saurus Guard'	, 'Seraphon'	, 'Order'	, 5		, 20	, 100	)
INSERT INTO UNIT (id, name, army, allegiance, min, max, points) VALUES (3, 'Skink'			, 'Seraphon'	, 'Order'	, 10	, 40	, 60	)
INSERT INTO UNIT (id, name, army, allegiance, min, max, points) VALUES (4, 'Saurus Knight'	, 'Seraphon'	, 'Order'	, 5		, 15	, 150	)

INSERT INTO ALLEGIANCE (allegianceId, allegiance) VALUES (1, 'Order')
INSERT INTO ALLEGIANCE (allegianceId, allegiance) VALUES (2, 'Chaos')
INSERT INTO ALLEGIANCE (allegianceId, allegiance) VALUES (3, 'Destruction')
INSERT INTO ALLEGIANCE (allegianceId, allegiance) VALUES (4, 'Death')

INSERT INTO ARMY (id, name, allegiance) VALUES (1, 'Seraphon', 'Order')