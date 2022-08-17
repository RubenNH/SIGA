package Siga.Servicios.Asesorias;

import Siga.Modelos.Asesorias.BeanAsesorias;
import Siga.Modelos.Asesorias.DaoAsesorias;
import Siga.Utils.ResultAction;
import java.util.List;
public class ServiceAsesorias {
    DaoAsesorias daoAseso = new DaoAsesorias();

    public List<BeanAsesorias> getAll(){
        return daoAseso.findAll();
    }
    public List<BeanAsesorias> getAllAD(){
        return daoAseso.admindAll();
    }


    public BeanAsesorias getAsesoria(Long id){ return daoAseso.findOne(id);}

    public List<BeanAsesorias> getAsesorias(Long id){ return daoAseso.findMynes(id);}

    public ResultAction update(BeanAsesorias asesoria){
        ResultAction resultado = new ResultAction();
        if (daoAseso.update(asesoria)){
            resultado.setStatus(200);
            resultado.setResult(false);
            resultado.setMessage("Pokemon actualizado correctamente");
        }else{
            resultado.setStatus(400);
            resultado.setResult(true);
            resultado.setMessage("Ocurrió un error");
        }
        return resultado;
    }

    public ResultAction save(BeanAsesorias Addasesorias){
        ResultAction result = new ResultAction();
        if (daoAseso.save(Addasesorias)){
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
}
