<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un Produit</title>
</head>
<body>
    <h2>Ajouter un Produit</h2>

    <form action="produits" method="post">
        <label>ID :</label>
        <input type="number" name="id" required><br><br>

        <label>Nom :</label>
        <input type="text" name="nom" required><br><br>

        <label>Description :</label>
        <textarea name="description" required></textarea><br><br>

        <label>Prix :</label>
        <input type="number" step="0.01" name="prix" required><br><br>

        <label>URL de l'image :</label>
        <input type="text" name="image" required><br><br>

        <button type="submit">Ajouter / Modifier</button>
    </form>

    <br>
    <a href="produits">Retour à la liste des produits</a>
</body>
</html>

