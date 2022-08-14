package Siga.Controlador.acceso;

import Siga.Modelos.Asesorias.BeanAsesorias;
import Siga.Controlador.Asesorias.ServletAsesorias;
import Siga.Modelos.Acceso.BeanUser;
import Siga.Modelos.Asesorias.BeanAsesorias;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "ServletLogeo",
        urlPatterns = {
                "/login",
                "/logout",
                "/add-user",
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
            case "/add-user":
                try {
                    String usernameAdd = req.getParameter("username");
                    String passwordAdd = req.getParameter("password");
                    String EstatusAdd = req.getParameter("estatus");
                    String NomreAdd = req.getParameter("nombres");
                    String ApellidoAdd = req.getParameter("apellidos");
                    BeanUser AddUsar = new BeanUser();
                    AddUsar.setUsername(usernameAdd);
                    AddUsar.setPassword(passwordAdd);
                    AddUsar.setStatus(Integer.parseInt(EstatusAdd));
                    AddUsar.setNombre(NomreAdd);
                    AddUsar.setApellidos(ApellidoAdd);
                    ResultAction result = authService.saveUser(AddUsar);
                    authService.getId(AddUsar.getUsername());
                    session = req.getSession();
                    session.setAttribute("user", AddUsar);
                    if(AddUsar.getStatus() == 1){
                        urlRedirect = "/formEstudainte.jsp";
                    }
                    if(AddUsar.getStatus() == 2){
                        urlRedirect = "/formDocente.jsp";
                    }
                } catch (Exception e) {
                    Logger.getLogger(ServletAsesorias.class.getName()).log(Level.SEVERE,
                            "Error AddAsesoria method" + e.getMessage());
                    urlRedirect = "/index.jsp?result=false&message=" +
                            URLEncoder.encode("Error al registrar",
                                    StandardCharsets.UTF_8.name())
                            + "&status=400";
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