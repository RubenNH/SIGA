package Siga.Servicios.estudiantes;

import Siga.Modelos.Acceso.BeanUser;
import Siga.Modelos.Acceso.DaoUser;
import Siga.Modelos.Estudiante.BeanEstudiante;
import Siga.Modelos.Estudiante.DaoEstudiante;
import Siga.Utils.ResultAction;

public class ServiceEstudiante {

    DaoEstudiante daoEstudiante = new DaoEstudiante();

    public ResultAction saveEstudiante(BeanEstudiante AddEstudiante){
        ResultAction result = new ResultAction();
        if (daoEstudiante.saveEstudiante(AddEstudiante)){
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
