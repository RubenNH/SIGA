package Siga.Servicios.Acceso;

//import Siga.Modelos.Asesorias.BeanAseso;
import Siga.Modelos.Acceso.BeanUser;
import Siga.Modelos.Acceso.DaoUser;
import Siga.Utils.ResultAction;
import java.util.List;

public class ServiceUSer {
    DaoUser auth = new DaoUser();

    public BeanUser login(String username, String password) {
        return auth.validate(username, password);
    }
}
