INSERT INTO Client VALUES(100, 'USA Denver','Client Test1','denver@test.com', 'Liquid Denver & Co','0102030405');
INSERT INTO Client VALUES(101, 'USA New york','Client Test2','ny@test.com', 'Liquid NY & Co','0102030405');
INSERT INTO Client VALUES(102, 'USA Miami','Client Test3','miami@test.com', 'Liquid Miami & Co','0102030405');

INSERT INTO Produit VALUES (1,'gout chocolat', 'Liquid Choco', '/img/produits/original-american-mix-10-ml.jpg', 999 );
INSERT INTO Produit VALUES (2,'gout menthe', 'Liquid Menthe', '/img/produits/original-american-mix-10-ml.jpg', 999 );

INSERT INTO COMMANDE VALUES(1, 0, current date, 230, 100);
INSERT INTO COMMANDE VALUES(2, 1, current date, 370, 101);
 
INSERT INTO LIGNE_COMMANDE VALUES(1, 50,3,1, 1);
INSERT INTO LIGNE_COMMANDE VALUES(2, 40,2,1, 2);
INSERT INTO LIGNE_COMMANDE VALUES(3, 50,5,2, 1);
INSERT INTO LIGNE_COMMANDE VALUES(4, 40,3,2, 2);