package SIGA.Controller.Auth;

import SIGA.Model.Asesorias.BeanAseso;
import SIGA.Model.Auth.BeanUser;
import SIGA.Service.Auth.AuthService;
import SIGA.Utils.ResultAction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ServletAuth",
        urlPatterns = {
                "/login",
                "/logout",
                "/add-user"
        })

public class ServletAuth extends HttpServlet {
    String action;
    String urlRedirect = "/get-log";
    HttpSession session;
    AuthService authService = new AuthService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        action = req.getServletPath();
        switch (action) {
            case "/login":
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                BeanUser user = authService.login(username, password);
                if (user != null) {
                    session = req.getSession();
                    session.setAttribute("user", user);
                    if(user.getStatus() == 1){
                        urlRedirect = "/get-acceso1";
                    }
                    if(user.getStatus() == 2){
                        urlRedirect = "/get-acceso2";
                    }
                    if(user.getStatus() == 3){
                        urlRedirect = "/get-acceso3";
                    }
                } else {
                    urlRedirect = "/?message=" + URLEncoder.encode(
                            "Usuario y/o contraseña incorrectos",
                            StandardCharsets.UTF_8.name());
                }
                break;
            case "/add-user":
                String username1 = req.getParameter("username");
                String password1 = req.getParameter("password");
                String estatus = req.getParameter("estatus");
                String nombres = req.getParameter("nombres");
                String apellidos = req.getParameter("apellidos");
                BeanUser user1 = new BeanUser();
                user1.setUsername(username1);
                user1.setPassword(password1);
                user1.setStatus(Integer.parseInt(estatus));
                user1.setNombre(nombres);
                user1.setApellidos(apellidos);
                ResultAction result = authService.save(user1);
                urlRedirect = "/get-acceso?result=" +
                        result.isResult() + "&message=" +
                        URLEncoder.encode(result.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + result.getStatus();
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