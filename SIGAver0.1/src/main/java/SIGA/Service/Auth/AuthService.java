package SIGA.Service.Auth;

import SIGA.Model.Asesorias.BeanAseso;
import SIGA.Model.Auth.BeanUser;
import SIGA.Model.Auth.DaoAuth;
import SIGA.Utils.ResultAction;
import java.util.List;

public class AuthService {

    DaoAuth auth = new DaoAuth();

    public BeanUser login(String username, String password) {
        return auth.validate(username, password);
    }

    public ResultAction save(BeanUser user){
        ResultAction result = new ResultAction();
        if (auth.save(user)){
            result.setResult(true);
            result.setMessage("Asesoria solicitada correctamente");
            result.setStatus(200);
        }else {
            result.setResult(false);
            result.setMessage("Ocurrió un error al registrar");
            result.setStatus(400);
        }
        return result;
    }
}


