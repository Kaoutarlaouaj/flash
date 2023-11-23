package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
@WebServlet("/AuthentificationServlet")
public class myServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les valeurs du formulaire
        String utilisateur = request.getParameter("user");
        String passe = request.getParameter("pass");

        // Afficher les valeurs dans la réponse HTTP
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Données saisies dans le formulaire :</h1>");
        out.println("<p>Login : " + utilisateur + "</p>");
        out.println("<p>Password : " + passe + "</p>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}