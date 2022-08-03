package SIGA.Controller.Auth;

import SIGA.Model.Auth.BeanUser;
import SIGA.Service.Auth.AuthService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "ServletAuth",
        urlPatterns = {"/login", "/logout"})
public class ServletAuth extends HttpServlet {
    String action;
    String urlRedirect = "/get-log";
    HttpSession session;
    AuthService authService = new AuthService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        action = req.getServletPath();
        switch (action) {
            case "/login":
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                BeanUser user = authService.login(username, password);
                if (user != null) {
                    session = req.getSession();
                    session.setAttribute("user", user);
                    //user.getRole() == "ADMIN" -> /dashboard
                    //user.getRole() == "STUDENT" -> /perfil
                    urlRedirect = "/get-acceso";
                } else {
                    urlRedirect = "/?message=" + URLEncoder.encode(
                            "Usuario y/o contraseña incorrectos",
                            StandardCharsets.UTF_8.name());
                }
                break;
            default:
                session = req.getSession();
                session.invalidate();
                urlRedirect = "/";
                break;
        }
        resp.sendRedirect(req.getContextPath() + urlRedirect);
    }
}