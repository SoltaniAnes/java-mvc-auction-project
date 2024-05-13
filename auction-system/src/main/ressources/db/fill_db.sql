-- Insertion des utilisateurs
INSERT INTO UTILISATEUR (EMAIL, NOM, PRENOM, ADRESSE) VALUES
('utilisateur1@example.com', 'Dupont', 'Jean', '1 rue des Lilas, 75001 Paris'),
('utilisateur2@example.com', 'Martin', 'Marie', '15 avenue du Château, 69002 Lyon'),
('utilisateur3@example.com', 'Durand', 'Pierre', '28 rue des Roses, 13003 Marseille');

-- Insertion des catégories
INSERT INTO CATEGORIE (NOM, DESCRIPTION) VALUES
('Electronique', 'Produits électroniques et high-tech'),
('Mode', 'Vêtements, chaussures, accessoires'),
('Maison', 'Articles pour la maison');

-- Insertion des produits
INSERT INTO PRODUIT (ID_PRODUIT, NOM, PRIX_REVIENT, STOCK, CATEGORIE) VALUES
(1, 'Smartphone', 300, 50, 'Electronique'),
(2, 'Ordinateur portable', 800, 30, 'Electronique'),
(3, 'Montre', 100, 20, 'Mode'),
(4, 'Chemise', 30, 50, 'Mode'),
(5, 'Canapé', 500, 10, 'Maison');

-- Insertion des caractéristiques des produits
INSERT INTO CARECTERISTIQUE (ID_PRODUIT, NOM, VALEUR) VALUES
(1, 'Marque', 'Samsung'),
(1, 'Couleur', 'Noir'),
(2, 'Marque', 'HP'),
(2, 'Couleur', 'Argent'),
(3, 'Type', 'Analogique'),
(3, 'Matériau', 'Acier inoxydable'),
(4, 'Taille', 'M'),
(4, 'Couleur', 'Blanc'),
(5, 'Matériau', 'Cuir'),
(5, 'Couleur', 'Gris');

-- Insertion des types de vente
INSERT INTO TYPE_VENTE (TYPE) VALUES
('MONTANTE'),
('DESCENDANTE');

-- Insertion des salles de vente
INSERT INTO SALLE_VENTE (ID_SALLE, CATEGORIE, DESCRIPTION, TYPE) VALUES
(1, 'Electronique', 'Salle de vente pour les produits électroniques', 'MONTANTE'),
(2, 'Mode', 'Salle de vente pour les vêtements et accessoires', 'DESCENDANTE'),
(3, 'Maison', 'Salle de vente pour les articles de maison', 'MONTANTE');

-- Insertion des ventes
INSERT INTO VENTE (ID_VENTE, EMAIL, ID_PRODUIT, ID_SALLE, PRIX_DEPART, DATE_DEBUT, DUREE, REVOCABLE, ENCHERE_UNIQUE) VALUES
(1, 'utilisateur1@example.com', 1, 1, 250, '2024-05-13', 7, 1, 0),
(2, 'utilisateur2@example.com', 3, 2, 50, '2024-05-14', 5, 0, 1),
(3, 'utilisateur3@example.com', 5, 3, 300, '2024-05-15', 10, 1, 1);

-- Insertion des enchères
INSERT INTO ENCHERE (ID_ENCHERE, EMAIL, ID_VENTE, PRIX_ACHAT, DATE_ENCHERE) VALUES
(1, 'utilisateur2@example.com', 1, 280, '2024-05-13'),
(2, 'utilisateur3@example.com', 2, 60, '2024-05-15'),
(3, 'utilisateur1@example.com', 3, 350, '2024-05-16');
