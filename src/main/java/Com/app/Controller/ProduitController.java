package Com.app.Controller;

import Com.app.dao.ProduitDAO;
import Com.app.metier.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/produits")
public class ProduitController extends HttpServlet {
    private ProduitDAO produitDAO;

    public ProduitController() {
        this.produitDAO = new ProduitDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Produit> produits = produitDAO.getAllProduits();
        request.setAttribute("produits", produits);
        request.getRequestDispatcher("produit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        BigDecimal prix = new BigDecimal(request.getParameter("prix"));
        String image = request.getParameter("image");

        Produit produit = new Produit();
        produit.setNom(nom);
        produit.setDescription(description);
        produit.setPrix(prix);
        produit.setImage(image);

        produitDAO.ajouterProduit(produit);
        response.sendRedirect("produits"); // Rediriger vers la liste des produits après l'ajout
    }
}
