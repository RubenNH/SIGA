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
                "/send-email",
        })

public class ServletLogeo extends HttpServlet {
    String action;
    String urlRedirect = "/get-log";
    HttpSession session;
    ServiceUSer authService = new ServiceUSer();
    ServletAsesorias servicio = new ServletAsesorias();

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
            case "/send-email":
                String email = req.getParameter("username");
                if (email != null) {
                    authService.sendEmail(email);
                    urlRedirect = "/index.jsp?message=" + URLEncoder.encode(
                            "Si existe una cuenta con este usuario," +
                                    " se ha enviado un correo electrónico.",
                            StandardCharsets.UTF_8.name());
                } else {
                    urlRedirect = "/index.jsp?message=" + URLEncoder.encode(
                            "Error al enviar el correo de recuperación",
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
            case "/add-estudiante":
                try {
                    BeanUser pan =  new BeanUser();
                    int pancito = pan.getId();
                    String matriculaAdd = req.getParameter("id_Matricula");
                    String telefonoAdd = req.getParameter("telefono");
                    String generoAdd = req.getParameter("genero");
                    String Fk_UsuarioAdd = String.valueOf(pancito);
                    String Fk_CarreraAdd = req.getParameter("Fk_Carrera");
                    String Fk_CuatriAdd = req.getParameter("Fk_Cuatri");
                    BeanUser AddEstudainte = new BeanUser();
                    AddEstudainte.setId_Matricula(matriculaAdd);
                    AddEstudainte.setTelefono(Integer.parseInt(telefonoAdd));
                    AddEstudainte.setGenero(Integer.parseInt(generoAdd));
                    AddEstudainte.setFk_Usuario(Integer.parseInt(Fk_UsuarioAdd));
                    AddEstudainte.setFk_Carrera(Integer.parseInt(Fk_CarreraAdd));
                    AddEstudainte.setFk_Cuatri(Integer.parseInt(Fk_CuatriAdd));
                    ResultAction result = authService.saveEstudiante(AddEstudainte);
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


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        switch (action) {
            case "/get-UserE":
                BeanUser user = new BeanUser();
                int id = user.getId();
                try {
                    BeanUser estudiante = authService.getEstudiante((long) id);
                    request.setAttribute("usuario", estudiante);
                    urlRedirect = "/miCuenta.jsp";
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