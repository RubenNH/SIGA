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
                "/get-cancel",
                "/deleteP",
                "/deleteA",
                "/dar-permiso",
                "/cancel",
                "/new-docentes",
                "/new-asesoria",
                "/add-materia",
                "/add-profe",
                "/add-asesorias",
                "/get-doc",
                "/get-asesorias",
                "/get-myMat",
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
            case "/add-materia":
                Asesorias newAseso = ServiceA.localizateEst();
                String idMa = req.getParameter("id");
                newAseso.setFkMaterias(Integer.parseInt(idMa));
                resultAction reresult = ServiceA.addMateria(newAseso);
                urlRedirect = "/get-doc?result=" +
                        reresult.isResult() + "&message=" +
                        URLEncoder.encode(reresult.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + reresult.getStatus();
                break;
            case "/add-profe":
                Asesorias newA = ServiceA.getAs();
                int idAssoria = newA.getIdAsesorias();
                String idDo = req.getParameter("id");
                Asesorias dek = new Asesorias();
                dek.setIdAsesorias(idAssoria);
                dek.setFkProfesores(Integer.parseInt(idDo));
                resultAction wresult = ServiceA.addDoc(dek);
                urlRedirect = "/get-asesorias?result=" +
                        wresult.isResult() + "&message=" +
                        URLEncoder.encode(wresult.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + wresult.getStatus();
                break;
            case "/add-asesorias":
                String idAsesoeia = req.getParameter("id");
                String tema = req.getParameter("tema");
                String duda = req.getParameter("duda");
                Asesorias SaveAesoria = new Asesorias();
                SaveAesoria.setIdAsesorias(Integer.parseInt(idAsesoeia));
                SaveAesoria.setTema(tema);
                SaveAesoria.setDuda(duda);
                resultAction resuy = ServiceA.addTema(SaveAesoria);
                urlRedirect = "/locate-estudiante?result=" +
                        resuy.isResult() + "&message=" +
                        URLEncoder.encode(resuy.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + resuy.getStatus();
                break;
            case "/dar-permiso":
                String idPp = req.getParameter("id");
                String permiso = req.getParameter("permiso");
                Asesorias perm = new Asesorias();
                perm.setIdUsers(Integer.parseInt(idPp));
                perm.setPermiso(Integer.parseInt(permiso));
                resultAction reessult = ServiceA.darPermiso(perm);
                urlRedirect = "/new-docentes?result=" +
                        reessult.isResult() + "&message=" +
                        URLEncoder.encode(reessult.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + reessult.getStatus();
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
            case "/cancel":
                String idCa = req.getParameter("id");
                String razonE = req.getParameter("razon");
                Asesorias can = new Asesorias();
                can.setIdAsesorias(Integer.parseInt(idCa));
                can.setRazon(razonE);
                resultAction ressultC = ServiceA.cancel(can);
                urlRedirect = "/locate-estudiante?result=" +
                        ressultC.isResult() + "&message=" +
                        URLEncoder.encode(ressultC.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + ressultC.getStatus();
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
            case "/new-docentes":
                try {
                    List<Asesorias> asesorias = ServiceA.getND();
                    request.setAttribute("asesorias", asesorias);
                    urlRedirect = "/admin/newDoc.jsp";
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
            case "/get-cancel":
                String idA = request.getParameter("id");
                try {
                    request.setAttribute("id", idA);
                    urlRedirect = "/docente/rechazarA.jsp";
                } catch (Exception e) {
                    urlRedirect = "/index.jsp";
                }
                break;
            case "/get-doc":
                try {
                    Asesorias newA = ServiceA.getAs();
                    int idMateria = newA.getFkMaterias();
                    List<Asesorias> asesorias = ServiceA.getP(idMateria);
                    request.setAttribute("asesorias", asesorias);
                    urlRedirect = "/admin/addProfe.jsp";
                } catch (Exception e) {
                    urlRedirect = "/index.jsp";
                }
                break;
            case "/get-asesorias":
                try {
                    Asesorias newA = ServiceA.getAs();
                    int idAsesoria = newA.getIdAsesorias();
                    request.setAttribute("id", idAsesoria);
                    urlRedirect = "/admin/addAsesoria.jsp";
                } catch (Exception e) {
                    urlRedirect = "/index.jsp";
                }
                break;
            case "/deleteP":
                usersBean iser = authService.localizateD();
                int id1 = iser.getId();
                System.out.println(9);
                System.out.println(id1);
                try {
                    resultAction ressultt = ServiceA.delP(id1);
                    urlRedirect = "/historial-docente?result=" +
                            ressultt.isResult() + "&message=" +
                            URLEncoder.encode(ressultt.getMessage(), StandardCharsets.UTF_8.name())
                            + "&status=" + ressultt.getStatus();
                } catch (Exception e) {
                    urlRedirect = "/index.jsp";
                }
                break;
            case "/deleteA":
                try {
                    resultAction ressultt = ServiceA.delA();
                    urlRedirect = "/get-all?result=" +
                            ressultt.isResult() + "&message=" +
                            URLEncoder.encode(ressultt.getMessage(), StandardCharsets.UTF_8.name())
                            + "&status=" + ressultt.getStatus();
                } catch (Exception e) {
                    urlRedirect = "/index.jsp";
                }
                break;
            case "/new-asesoria":
                try {
                    Asesorias newA = ServiceA.localizateEst();
                    List<Asesorias> asesorias = ServiceA.getMat(newA);
                    request.setAttribute("asesorias", asesorias);
                    urlRedirect = "/solicitrAsesoria.jsp";
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
