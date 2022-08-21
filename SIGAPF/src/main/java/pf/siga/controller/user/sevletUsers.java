package pf.siga.controller.user;

import pf.siga.model.asesorias.Asesorias;
import pf.siga.model.users.usersBean;
import pf.siga.model.users.usersDao;
import pf.siga.service.asesorias.serviceAsesorias;
import pf.siga.service.users.serviceUser;
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
                "/locate-estudiante",
                "/locate-docente",
                "/historial-docente",
        })

public class sevletUsers extends HttpServlet {
    String action;
    String urlRedirect = "/index.jsp";
    HttpSession session;
    serviceUser authService = new serviceUser();
    serviceAsesorias ServiceA = new serviceAsesorias();

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
                usersBean user = authService.login(username, password);
                if (user != null) {
                    session = req.getSession();
                    session.setAttribute("user", user);
                    if(user.getStatus() == 1){
                        try {
                            urlRedirect = "/locate-estudiante";
                        } catch (Exception e) {
                            urlRedirect = "/index.jsp";
                        }
                    }
                    if(user.getStatus() == 2){
                        urlRedirect = "/locate-docente";
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

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        switch (action) {
            case "/locate-estudiante":
                try {
                    usersBean iser = authService.localizateE();
                    String username = iser.getUsername();
                    List<Asesorias> asesorias = ServiceA.getAllE(username);
                    request.setAttribute("asesoris", asesorias);
                    urlRedirect = "/estIndex.jsp";
                } catch (Exception e) {
                    urlRedirect = "/index.jsp";
                }
                break;
            case "/locate-docente":
                try {
                    usersBean iser = authService.localizateE();
                    String username = iser.getUsername();
                    List<Asesorias> asesorias = ServiceA.getAllD(username);
                    request.setAttribute("asesoris", asesorias);
                    urlRedirect = "/docente/index.jsp";
                } catch (Exception e) {
                    urlRedirect = "/index.jsp";
                }
                break;
            case "/historial-docente":
                try {
                    usersBean iser = authService.localizateE();
                    String username = iser.getUsername();
                    List<Asesorias> asesorias = ServiceA.getAllD(username);
                    request.setAttribute("asesoris", asesorias);
                    urlRedirect = "/docente/historial.jsp";
                } catch (Exception e) {
                    urlRedirect = "/index.jsp";
                }
                break;
            default:
                urlRedirect = "/index.jsp";
                break;
        }
        request.getRequestDispatcher(urlRedirect).forward(request, response);
    }
}
