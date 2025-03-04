<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Liste des Produits</title>
</head>
<body>
    <h1>Liste des Produits</h1>
    <table border="1">
        <tr>
            <th>Nom</th><th>Description</th><th>Prix</th><th>Image</th>
        </tr>
        <c:forEach var="produit" items="${produits}">
            <tr>
                <td>${produit.nom}</td>
                <td>${produit.description}</td>
                <td>${produit.prix} €</td>
                <td><img src="${produit.image}" width="100"></td>
            </tr>
        </c:forEach>
    </table>
    <a href="ajouterProduit.jsp">Ajouter un Produit</a>
</body>
</html>
