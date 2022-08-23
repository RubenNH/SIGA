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

    public List<Asesorias> getAllD(String username){return daoAsesorias.findAllD(username);}
    public List<Asesorias> getHisD(String username){return daoAsesorias.histoD(username);}
    public Asesorias getCu(String username){return daoAsesorias.findD(username);}

    public resultAction termAse(Asesorias add){
        resultAction result = new resultAction();
        if (daoAsesorias.pase(add)){
            result.setResult(true);
            result.setMessage(" registrado correctamente");
            result.setStatus(200);
        }else {
            result.setResult(false);
            result.setMessage(" Ocurrió un error al registrar");
            result.setStatus(400);
        }
        return result;
    }

    public resultAction rechazo(Asesorias rechazar){
        resultAction result = new resultAction();
        if (daoAsesorias.recha(rechazar)){
            result.setResult(true);
            result.setMessage(" registrado correctamente");
            result.setStatus(200);
        }else {
            result.setResult(false);
            result.setMessage(" Ocurrió un error al registrar");
            result.setStatus(400);
        }
        return result;
    }

    public resultAction delP(int id){
        resultAction result = new resultAction();
        if (daoAsesorias.delP(id)){
            result.setResult(true);
            result.setMessage(" registrado correctamente");
            result.setStatus(200);
        }else {
            result.setResult(false);
            result.setMessage(" Ocurrió un error al registrar");
            result.setStatus(400);
        }
        return result;
    }
}
