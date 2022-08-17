package Siga.Servicios.Acceso;

import Siga.Modelos.Acceso.BeanUser;
import Siga.Modelos.Acceso.DaoUser;
import Siga.Modelos.Asesorias.BeanAsesorias;
import Siga.Utils.ResultAction;
import Siga.Utils.emailService;

public class ServiceUSer {
    DaoUser auth = new DaoUser();

    public BeanUser login(String username, String password) {
        return auth.validate(username, password);
    }

    public BeanUser getEstudiante(Long id){ return auth.findOneEst(id);}

    public ResultAction saveUser(BeanUser AddUser){
        ResultAction result = new ResultAction();
        if (auth.saveUser(AddUser)){
            result.setResult(true);
            result.setMessage("Pokemon registrado correctamente");
            result.setStatus(200);
        }else {
            result.setResult(false);
            result.setMessage("Ocurrió un error al registrar");
            result.setStatus(400);
        }
        return result;
    }

    public ResultAction saveEstudiante(BeanUser AddEstudiante){
        ResultAction result = new ResultAction();
        if (auth.saveEstudiante(AddEstudiante)){
            result.setResult(true);
            result.setMessage("Pokemon registrado correctamente");
            result.setStatus(200);
        }else {
            result.setResult(false);
            result.setMessage("Ocurrió un error al registrar");
            result.setStatus(400);
        }
        return result;
    }


    public void sendEmail(String username){
        if (auth.verifyUser(username)){
            new emailService().sendEmail(username);
        }
    }
}
