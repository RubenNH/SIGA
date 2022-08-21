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
                "/get-rechazo",
                "/deleteP",
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
                String id = req.getParameter("id");
                String time = req.getParameter("time");
                String estado = req.getParameter("estado");
                Asesorias add = new Asesorias();
                add.setIdAsesorias(Integer.parseInt(id));
                add.setTiempo(Integer.parseInt(time));
                add.setFkEstados(Integer.parseInt(estado));
                resultAction reressult = ServiceA.termAse(add);
                urlRedirect = "/locate-docente?result=" +
                        reressult.isResult() + "&message=" +
                        URLEncoder.encode(reressult.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + reressult.getStatus();
                break;
            case "/rechazar":
                String idRa = req.getParameter("id");
                String razon = req.getParameter("razon");
                Asesorias rech = new Asesorias();
                rech.setIdAsesorias(Integer.parseInt(idRa));
                rech.setRazon(razon);
                resultAction ressult = ServiceA.rechazo(rech);
                urlRedirect = "/locate-docente?result=" +
                        ressult.isResult() + "&message=" +
                        URLEncoder.encode(ressult.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + ressult.getStatus();
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
            case "/get-rechazo":
                String id = request.getParameter("id");
                try {
                    request.setAttribute("id", id);
                    urlRedirect = "/docente/rechazar.jsp";
                } catch (Exception e) {
                    urlRedirect = "/index.jsp";
                }
                break;
            case "/deleteP":
                String id1 = request.getParameter("id");
                try {
                    request.setAttribute("id", id1);
                    resultAction ressultt = ServiceA.delP(Integer.parseInt(id1));
                    urlRedirect = "/historial-docente?result=" +
                            ressultt.isResult() + "&message=" +
                            URLEncoder.encode(ressultt.getMessage(), StandardCharsets.UTF_8.name())
                            + "&status=" + ressultt.getStatus();
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