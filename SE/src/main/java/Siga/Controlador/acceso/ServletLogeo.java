package Siga.Controlador.acceso;

//import Siga.Modelos.Asesorias.BeanAseso;
import Siga.Modelos.Acceso.BeanUser;
import Siga.Servicios.Acceso.ServiceUSer;
import Siga.Servicios.Acceso.ServiceUSer;
import Siga.Utils.ResultAction;
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

@WebServlet(name = "ServletLogeo",
        urlPatterns = {
                "/login",
                "/logout",
                "/add-user"
        })

public class ServletLogeo extends HttpServlet {
    String action;
    String urlRedirect = "/get-log";
    HttpSession session;
    ServiceUSer authService = new ServiceUSer();

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
                        urlRedirect = "/get-estudiante";
                    }
                    if(user.getStatus() == 2){
                        urlRedirect = "/get-docente";
                    }
                    if(user.getStatus() == 3){
                        urlRedirect = "/get-admin";
                    }
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