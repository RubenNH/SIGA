package SIGA.Controller.Asesorias;

import SIGA.Model.Asesorias.BeanAseso;
import SIGA.Service.Asesorias.ServiceAsesorias;
import SIGA.Utils.ResultAction;
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

@WebServlet(name = "ServletAcccs",
        urlPatterns = {
                "/get-acceso1",
                "/get-acceso2",
                "/get-acceso3",
                "/add-aseso",
                "/solicitar-aseso",
                "/save-aseso",
                "/get-aseso",
                "/cancel-aseso"
        })

public class ServletAccs extends HttpServlet {
    Logger logger = Logger.getLogger("ServletAccs");
    String action;
    String urlRedirect = "/get-acceso";
    ServiceAsesorias ServiceAsesorias = new ServiceAsesorias();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        logger.log(Level.INFO, "Path-> " + action);
        switch (action) {
            case "/get-acceso1":
                List<BeanAseso> asesorias = ServiceAsesorias.getAll();
                System.out.println(asesorias.size());
                request.setAttribute("asesoria", asesorias);
                urlRedirect = "/views/estudiantes/index.jsp";
                break;
            case "/get-acceso2":
                List<BeanAseso> asesorias1 = ServiceAsesorias.getAll();
                System.out.println(asesorias1.size());
                request.setAttribute("asesoria", asesorias1);
                urlRedirect = "/views/Docentes/index.jsp";
                break;
            case "/get-acceso3":
                List<BeanAseso> asesorias2 = ServiceAsesorias.getAll();
                System.out.println(asesorias2.size());
                request.setAttribute("asesoria", asesorias2);
                urlRedirect = "/views/Admin/index.jsp";
                break;
            case "/solicitar-aseso":
                urlRedirect = "/views/estudiantes/create.jsp";
                break;
            case "/get-aseso":
                String id = request.getParameter("id");
                id = (id == null) ? "0" : id;
                try {
                    BeanAseso asesoria = ServiceAsesorias.getAseso(Long.parseLong(id));
                    request.setAttribute("asesoria", asesoria);
                    urlRedirect = "/views/estudiantes/update.jsp";
                } catch (Exception e) {
                    urlRedirect = "/get-acceso";
                }
                break;
            default:
                request.setAttribute("asesorias", ServiceAsesorias.getAll());
                urlRedirect = "/get-acceso";
                break;
        }
        request.getRequestDispatcher(urlRedirect).forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        action = request.getServletPath();
        switch (action) {
            case "/add-aseso":
                String tema = request.getParameter("tema");
                String duda = request.getParameter("duda");
                String FkProfesores = request.getParameter("FkProfesores");
                String FkEstados = request.getParameter("FkEstados");
                String FkMatricula = request.getParameter("FkMatricula");
                BeanAseso asesoria = new BeanAseso();
                asesoria.setTema(tema);
                asesoria.setDuda(duda);
                asesoria.setFkProfesores(Integer.parseInt(FkProfesores));
                asesoria.setFkEstados(Integer.parseInt(FkEstados));
                asesoria.setFkMatricula(Integer.parseInt(FkMatricula));
                ResultAction result = ServiceAsesorias.save(asesoria);
                urlRedirect = "/get-acceso?result=" +
                        result.isResult() + "&message=" +
                        URLEncoder.encode(result.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + result.getStatus();
                break;
            case "/save-aseso":
                String tema2 = request.getParameter("tema");
                String duda2 = request.getParameter("duda");
                String FkProfesores2 = request.getParameter("FkProfesores");
                String FkEstados2 = request.getParameter("FkEstados");
                String FkMatricula2 = request.getParameter("FkMatricula");
                BeanAseso asesoria2 = new BeanAseso();
                asesoria2.setTema(tema2);
                asesoria2.setDuda(duda2);
                asesoria2.setFkProfesores(Integer.parseInt(FkProfesores2));
                asesoria2.setFkEstados(Integer.parseInt(FkEstados2));
                asesoria2.setFkMatricula(Integer.parseInt(FkMatricula2));
                ResultAction result2 = ServiceAsesorias.save(asesoria2);
                urlRedirect = "/get-acceso?result=" +
                        result2.isResult() + "&message=" +
                        URLEncoder.encode(result2.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + result2.getStatus();
                break;
            case "/cancel-aseso":
                String IdAsesoria = request.getParameter("id");
                ResultAction deleteResult = ServiceAsesorias.delete(IdAsesoria);
                urlRedirect = "/get-acceso?result=" +
                        deleteResult.isResult() + "&message=" +
                        URLEncoder.encode(deleteResult.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + deleteResult.getStatus();
                break;
            default:
                urlRedirect = "/get-acesso";
                break;
        }
        response.sendRedirect(request.getContextPath() + urlRedirect);
    }
}
