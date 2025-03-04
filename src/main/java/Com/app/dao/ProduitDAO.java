package Com.app.dao;

import Com.app.metier.Produit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/amitdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Android123&";

    public List<Produit> getAllProduits() {
        List<Produit> produits = new ArrayList<>();
        String query = "SELECT * FROM produits";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Produit produit = new Produit();
                produit.setId(rs.getInt("id"));
                produit.setNom(rs.getString("nom"));
                produit.setDescription(rs.getString("description"));
                produit.setPrix(rs.getBigDecimal("prix"));
                produit.setImage(rs.getString("image"));
                produits.add(produit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }

    public void ajouterProduit(Produit produit) {
        String query = "INSERT INTO produits (id,nom, description, prix, image) VALUES (?,?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1,produit.getId());
            stmt.setString(2, produit.getNom());
            stmt.setString(3, produit.getDescription());
            stmt.setBigDecimal(4, produit.getPrix());
            stmt.setString(5, produit.getImage());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mettreAJourProduit(Produit produit) {
        String query = "UPDATE produits SET nom = ?, description = ?, prix = ?, image = ? WHERE id = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setInt(1, produit.getId());
            stmt.setString(2, produit.getNom());
            stmt.setString(3, produit.getDescription());
            stmt.setBigDecimal(4, produit.getPrix());
            stmt.setString(5, produit.getImage());


            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
