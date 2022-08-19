package pf.siga.controller.asesoria;

import pf.siga.model.asesorias.asesoriasDao;
import pf.siga.model.asesorias.Asesorias;
import pf.siga.model.users.usersBean;
import pf.siga.service.asesorias.serviceAsesorias;
import pf.siga.service.users.serviceUser;
import pf.siga.utils.resultAction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "servletAsesoria",
        urlPatterns = {
                "/get-all",
                "/pas-list",
                "/add-estado",
                "/rechazar",
        })

public class servletAsesoria extends HttpServlet {
    Logger logger = Logger.getLogger("servletUsers");
    String action;
    String urlRedirect = "/index.jsp";
    serviceAsesorias ServiceA = new serviceAsesorias();
    serviceUser authService = new serviceUser();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        action = req.getServletPath();
        switch (action) {
            case "/add-estado":
                int time = Integer.parseInt(req.getParameter("time"));
                int estado = Integer.parseInt(req.getParameter("estado"));
                String id = req.getParameter("idAsesorias");
                ServiceA.paseLi(time, estado, Integer.parseInt(id));
                urlRedirect = "/locate-docente";
                break;
            case "/rechazar":
                int idRec = Integer.parseInt(req.getParameter("id"));
                ServiceA.rechazo(idRec);
                urlRedirect = "/locate-docente";
                break;
            default:
                urlRedirect = "/";
                break;
        }
        resp.sendRedirect(req.getContextPath() + urlRedirect);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        logger.log(Level.INFO, "Path-> " + action);
        switch (action) {
            case "/get-all":
                try {
                    List<Asesorias> asesorias = ServiceA.getAll();
                    request.setAttribute("asesorias", asesorias);
                    urlRedirect = "/admin/historial.jsp";
                } catch (Exception e) {
                    urlRedirect = "/index.jsp";
                }
                break;
            case "/pas-list":
                try {
                usersBean iser = authService.localizateE();
                String username = iser.getUsername();
                List<Asesorias> asesorias = ServiceA.getAllD(username);
                request.setAttribute("asesoris", asesorias);
                urlRedirect = "/docente/paseLista.jsp";
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
