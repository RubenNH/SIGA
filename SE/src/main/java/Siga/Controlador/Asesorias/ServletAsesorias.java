package Siga.Controlador.Asesorias;

import Siga.Modelos.Acceso.BeanUser;
import Siga.Modelos.Asesorias.DaoAsesorias;
import Siga.Modelos.Asesorias.BeanAsesorias;
import Siga.Servicios.Acceso.ServiceUSer;
import Siga.Servicios.Asesorias.ServiceAsesorias;
import Siga.Utils.ResultAction;
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

@WebServlet(name = "ServletAsesorias",
        urlPatterns = {
                "/get-estudiante",
                "/get-docente",
                "/get-admin",
                "/get-asesoria",
                "/save-asesoria",
                "/add-asesoria",
        })

public class ServletAsesorias extends HttpServlet {
    Logger logger = Logger.getLogger("ServletAccs");
    String action;
    String urlRedirect = "/index.jsp";
    ServiceAsesorias ServiceAsesorias = new ServiceAsesorias();
    ServiceUSer authService = new ServiceUSer();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        logger.log(Level.INFO, "Path-> " + action);
        switch (action) {
            case "/get-estudiante":
                try {
                    BeanUser net = new BeanUser();
                    int id = net.getId();
                    List<BeanAsesorias> asesorias = ServiceAsesorias.getAsesorias((long) id);
                    System.out.println(asesorias.size());
                    request.setAttribute("asesorias", asesorias);
                    urlRedirect = "/indexEstudiantes.jsp";
                } catch (Exception e) {
                    urlRedirect = "/index.jsp";
                }
                break;
            case "/get-docente":
                List<BeanAsesorias> asesorias = ServiceAsesorias.getAll();
                System.out.println(asesorias.size());
                request.setAttribute("asesoria", asesorias);
                urlRedirect = "/indexProfesor.jsp";
                break;
            case "/get-admin":
                List<BeanAsesorias> asesorias2 = ServiceAsesorias.getAllAD();
                System.out.println(asesorias2.size());
                request.setAttribute("asesoria", asesorias2);
                urlRedirect = "/admin.jsp";
                break;
            case "/get-asesoria":
                String id = request.getParameter("id");
                id = (id == null) ? "0" : id;
                try {
                    BeanAsesorias asesoria = ServiceAsesorias.getAsesoria(Long.valueOf((id)));
                    request.setAttribute("asesoria", asesoria);
                    urlRedirect = "/updateAsesorias.jsp";
                } catch (Exception e) {
                    urlRedirect = "/index.jsp";
                }
                break;
            default:
                request.setAttribute("asesorias", ServiceAsesorias.getAll());
                urlRedirect = "/index.jsp";
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
            case "/save-asesoria":
                String tema = request.getParameter("tema");
                String duda = request.getParameter("duda");
                String idAsesoria = request.getParameter("id");
                BeanAsesorias asesoria = new BeanAsesorias();
                asesoria.setTema(tema);
                asesoria.setDuda(duda);
                asesoria.setIdAsesorias(Integer.parseInt(((idAsesoria))));
                ResultAction resultado = ServiceAsesorias.update(asesoria);
                urlRedirect = "/get-estudiante?result=" +
                        resultado.isResult() + "&message=" +
                        URLEncoder.encode(resultado.getMessage(), StandardCharsets.UTF_8.name())
                        + "&status=" + resultado.getStatus();
                break;
            case "/add-asesoria":
                try {
                    String temaAdd = request.getParameter("tema");
                    String dudaAdd = request.getParameter("duda");
                    String MateriaAdd = request.getParameter("FkMateria");
                    String ProfesorAdd = request.getParameter("FkProfesor");
                    String MatriculaAdd = request.getParameter("FkMatricuka");
                    BeanAsesorias AddAsesoria = new BeanAsesorias();
                    AddAsesoria.setTema(temaAdd);
                    AddAsesoria.setDuda(dudaAdd);
                    AddAsesoria.setFkMaterias(Integer.parseInt(MateriaAdd));
                    AddAsesoria.setFkProfesores(Integer.parseInt(ProfesorAdd));
                    AddAsesoria.setFkMatricula(MatriculaAdd);
                    ResultAction result = ServiceAsesorias.save(AddAsesoria);
                    urlRedirect = "/get-estudiante?result=" +
                            result.isResult() + "&message=" +
                            URLEncoder.encode(result.getMessage(), StandardCharsets.UTF_8.name())
                            + "&status=" + result.getStatus();
                } catch (Exception e) {
                    Logger.getLogger(ServletAsesorias.class.getName()).log(Level.SEVERE,
                            "Error AddAsesoria method" + e.getMessage());
                    urlRedirect = "/get-estudiante?result=false&message=" +
                            URLEncoder.encode("Error al registrar",
                                    StandardCharsets.UTF_8.name())
                            + "&status=400";
                }
                break;
            default:
                urlRedirect = "/index.jsp";
                break;
        }
        response.sendRedirect(request.getContextPath() + urlRedirect);
    }


}