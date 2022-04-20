DROP TABLE IF EXISTS produit;
 
CREATE TABLE produit (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nom VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  prix Double NOT NULL
 
);
 
INSERT INTO produit (nom, description, prix) VALUES
  ('T-Shirt', 'AAAA', 125.30),
  ('Chaise', 'BBBB', 500.00),
  ('Meuble TV', 'CCCC', 2500.00);