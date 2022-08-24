package pf.siga.controller.user;

import pf.siga.model.asesorias.Asesorias;
import pf.siga.model.users.usersBean;
import pf.siga.model.users.usersDao;
import pf.siga.service.asesorias.serviceAsesorias;
import pf.siga.service.users.serviceUser;
import pf.siga.utils.resultAction;

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
                "/locate-admin",
                "/historial-docente",
                "/cuenta-docente",
                "/control-profesor",
                "/send-email",
                "/add-doc",
                "/add-est",
                "/get-cuentaEst",
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
                    if(user.getStatus() == 2 && user.getPermiso() == 1){
                        urlRedirect = "/SinAutorizacion.jsp";
                    }
                    if(user.getStatus() == 2 && user.getPermiso() == 2){
                        urlRedirect = "/locate-docente";
                    }
                    if(user.getStatus() == 3){
                        urlRedirect = "/locate-admin";
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
            case "/add-doc":
                try {
                    String usernameAdd = req.getParameter("username");
                    String passwordAdd = req.getParameter("password");
                    String NomreAdd = req.getParameter("nombres");
                    String ApellidoAdd = req.getParameter("apellidos");
                    int EstatusAdd = 2;
                    usersBean AddUsar = new usersBean();
                    AddUsar.setUsername(usernameAdd);
                    AddUsar.setPassword(passwordAdd);
                    AddUsar.setStatus(EstatusAdd);
                    authService.saveU(AddUsar);
                    usersBean asesorias = authService.localizateU(usernameAdd);
                    asesorias.setNombres(NomreAdd);
                    asesorias.setApellidos(ApellidoAdd);
                    resultAction result = authService.saveD(asesorias);
                    urlRedirect = "/index.jsp?result=" +
                            result.isResult() + "&message=" +
                            URLEncoder.encode(result.getMessage(), StandardCharsets.UTF_8.name())
                            + "&status=" + result.getStatus();
                } catch (Exception e) {
                    Logger.getLogger(sevletUsers.class.getName()).log(Level.SEVERE,
                            "Error AddAsesoria method" + e.getMessage());
                    urlRedirect = "/index.jsp?result=false&message=" +
                            URLEncoder.encode("Error al registrar",
                                    StandardCharsets.UTF_8.name())
                            + "&status=400";
                }
                break;
            case "/add-est":
                try {
                    String usernameAdd = req.getParameter("username");
                    String passwordAdd = req.getParameter("password");
                    String NomreAdd = req.getParameter("nombres");
                    String ApellidoAdd = req.getParameter("apellidos");
                    String MatAdd = req.getParameter("matricula");
                    String TlAdd = req.getParameter("telefono");
                    String GenAdd = req.getParameter("genero");
                    String XarAdd = req.getParameter("carrera");
                    String CuaAdd = req.getParameter("cuatri");
                    int EstatusAdd = 1;
                    usersBean AddUsar = new usersBean();
                    AddUsar.setUsername(usernameAdd);
                    AddUsar.setPassword(passwordAdd);
                    AddUsar.setStatus(EstatusAdd);
                    authService.saveU(AddUsar);
                    usersBean asesorias = authService.localizateU(usernameAdd);
                    asesorias.setNombres(NomreAdd);
                    asesorias.setApellidos(ApellidoAdd);
                    asesorias.setId_Matricula(MatAdd);
                    asesorias.setTelefono(Long.parseLong(TlAdd));
                    asesorias.setGenero(Integer.parseInt(GenAdd));
                    asesorias.setFk_Carrera(Integer.parseInt(XarAdd));
                    asesorias.setFk_Cuatri(Integer.parseInt(CuaAdd));
                    resultAction result = authService.saveE(asesorias);
                    urlRedirect = "/index.jsp?result=" +
                            result.isResult() + "&message=" +
                            URLEncoder.encode(result.getMessage(), StandardCharsets.UTF_8.name())
                            + "&status=" + result.getStatus();
                } catch (Exception e) {
                    Logger.getLogger(sevletUsers.class.getName()).log(Level.SEVERE,
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
                    List<Asesorias> asesorias = ServiceA.getHisD(username);
                    request.setAttribute("asesoris", asesorias);
                    urlRedirect = "/docente/historial.jsp";
                } catch (Exception e) {
                    urlRedirect = "/index.jsp";
                }
                break;
            case "/control-profesor":
                try {
                    usersBean iser = authService.localizateE();
                    String username = iser.getUsername();
                    Asesorias asesorias = ServiceA.getCu(username);
                    request.setAttribute("asesoris", asesorias);
                    urlRedirect = "/docente/cuenta.jsp";
                } catch (Exception e) {
                    urlRedirect = "/index.jsp";
                }
                break;
            case "/locate-admin":
                try {
                    usersBean asesorias = authService.AdminControl();
                    request.getSession().setAttribute("asesorias", asesorias);
                    urlRedirect = "/admin/index.jsp";
                } catch (Exception e) {
                    urlRedirect = "/index.jsp";
                }
                break;
            case "/cuenta-docente":
                try {
                    usersBean iser = authService.localizateE();
                    String username = iser.getUsername();
                    usersBean asesorias = authService.findDoc(username);
                    request.getSession().setAttribute("asesorias", asesorias);
                    urlRedirect = "/docente/cuenta.jsp";
                } catch (Exception e) {
                    urlRedirect = "/index.jsp";
                }
                break;
            case "/get-cuentaEst":
                try {
                    usersBean iser = authService.localizateE();
                    String username = iser.getUsername();
                    usersBean asesorias = authService.findEst(username);
                    request.getSession().setAttribute("asesorias", asesorias);
                    urlRedirect = "/docente/miCuenta.jsp";
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
