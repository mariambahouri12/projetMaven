<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, Com.app.metier.Produit" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Produits</title>
</head>
<body>
    <h2>Liste des Produits</h2>

    <a href="ajouterProduit.jsp">Ajouter un Produit</a>
    <br><br>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Image</th>
            <th>Nom</th>
            <th>Description</th>
            <th>Prix</th>
        </tr>
        <%
            List<Produit> produits = (List<Produit>) request.getAttribute("produits");
            if (produits != null) {
                for (Produit produit : produits) {
        %>
        <tr>
            <td><%= produit.getId() %></td>
            <td><img src="<%= produit.getImage() %>" width="100" alt="Image Produit"></td>
            <td><%= produit.getNom() %></td>
            <td><%= produit.getDescription() %></td>
            <td><%= produit.getPrix() %> €</td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="5">Aucun produit disponible.</td></tr>
        <% } %>
    </table>
</body>
</html>
