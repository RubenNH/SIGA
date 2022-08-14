package Siga.Controlador.estudiantes;

import Siga.Modelos.Asesorias.DaoAsesorias;
import Siga.Modelos.Estudiante.BeanEstudiante;
import Siga.Modelos.Estudiante.DaoEstudiante;
import Siga.Modelos.Asesorias.BeanAsesorias;
import Siga.Servicios.Asesorias.ServiceAsesorias;
import Siga.Servicios.estudiantes.ServiceEstudiante;
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
import Siga.Modelos.Asesorias.BeanAsesorias;
import Siga.Controlador.Asesorias.ServletAsesorias;
import Siga.Modelos.Acceso.BeanUser;
import Siga.Modelos.Asesorias.BeanAsesorias;
import Siga.Servicios.Acceso.ServiceUSer;
import Siga.Utils.ResultAction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ServletEstudiantes",
        urlPatterns = {
                "/add-estudiante",
        })

public class ServletEstudiantes extends HttpServlet {
    String action;
    String urlRedirect = "/get-log";
    HttpSession session;
    ServiceEstudiante EstService = new ServiceEstudiante();



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        action = req.getServletPath();
        BeanUser pan =  new BeanUser();
        int pancito = pan.getId();
        switch (action) {
            case "/add-estudiante":
                try {
                    String matriculaAdd = req.getParameter("id_Matricula");
                    String telefonoAdd = req.getParameter("telefono");
                    String generoAdd = req.getParameter("genero");
                    String Fk_UsuarioAdd = String.valueOf(pancito);
                    String Fk_CarreraAdd = req.getParameter("Fk_Carrera");
                    String Fk_CuatriAdd = req.getParameter("Fk_Cuatri");
                    BeanEstudiante AddEstudainte = new BeanEstudiante();
                    AddEstudainte.setId_Matricula(matriculaAdd);
                    AddEstudainte.setTelefono(Integer.parseInt(telefonoAdd));
                    AddEstudainte.setGenero(Integer.parseInt(generoAdd));
                    AddEstudainte.setFk_Usuario(Integer.parseInt(Fk_UsuarioAdd));
                    AddEstudainte.setFk_Carrera(Integer.parseInt(Fk_CarreraAdd));
                    AddEstudainte.setFk_Cuatri(Integer.parseInt(Fk_CuatriAdd));
                    ResultAction result = EstService.saveEstudiante(AddEstudainte);
                    urlRedirect = "/index.jsp?result=" +
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
                session = req.getSession();
                session.invalidate();
                urlRedirect = "/";
                break;
        }
        resp.sendRedirect(req.getContextPath() + urlRedirect);
    }
}
