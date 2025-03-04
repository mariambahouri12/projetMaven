<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Accueil</title>
</head>
<body>
    <%
        HttpSession sessionObj = request.getSession(false);
        String username = (sessionObj != null) ? (String) sessionObj.getAttribute("user") : null;

        if (username == null) {
            response.sendRedirect("login.jsp");
        }
    %>

    <h2>Bienvenue, <%= username %> !</h2>

    <a href="logout">Se déconnecter</a>
</body>
</html>
