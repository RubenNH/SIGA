package pf.siga.service.asesorias;

import pf.siga.model.asesorias.Asesorias;
import pf.siga.model.asesorias.asesoriasDao;
import pf.siga.model.users.usersBean;
import pf.siga.utils.resultAction;
import java.util.List;

public class serviceAsesorias {
    asesoriasDao daoAsesorias = new asesoriasDao();

    public List<Asesorias> getAll(){
        return daoAsesorias.findAll();
    }

    public List<Asesorias> getAllE(String username){
        return daoAsesorias.findAllE(username);
    }

    public List<Asesorias> getAllD(String username){
        return daoAsesorias.findAllD(username);
    }

    public Asesorias paseLi(int estado, int tiempo, int id) {
        return daoAsesorias.pase(estado, tiempo, id);
    }

    public Asesorias rechazo(int id) {
        return daoAsesorias.recha(id);
    }
}
