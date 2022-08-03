package SIGA.Service.Asesorias;

import SIGA.Model.Asesorias.BeanAseso;
import SIGA.Model.Asesorias.DaoAseso;
import SIGA.Utils.ResultAction;
import java.util.List;
public class ServiceAsesorias {
    DaoAseso daoAseso = new DaoAseso();

    public List<BeanAseso> getAll(){
        return daoAseso.findAll();
    }

    public ResultAction save(BeanAseso pokemon){
        ResultAction result = new ResultAction();
        if (daoAseso.save(pokemon)){
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

    public BeanAseso getPokemon(Long id){
        return daoAseso.findOne(id);
    }

    public ResultAction update(BeanAseso asesoria){
        ResultAction result = new ResultAction();
        if (daoAseso.update(asesoria)){
            result.setStatus(200);
            result.setResult(false);
            result.setMessage("Asesoria modificada correctamente");
        }else{
            result.setStatus(400);
            result.setResult(true);
            result.setMessage("Error");
        }
        return result;
    }

    public ResultAction delete(String id){
        ResultAction result = new ResultAction();
        try{
            if (daoAseso.delete(Long.parseLong(id))){
                result.setStatus(200);
                result.setResult(false);
                result.setMessage("Assoria cancelada correctamente");
            }else{
                result.setStatus(400);
                result.setResult(true);
                result.setMessage("Error");
            }
        }catch (NumberFormatException e){
            result.setStatus(400);
            result.setResult(true);
            result.setMessage("Error");
        }
        return result;
    }
}
