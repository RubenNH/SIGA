package pf.siga.service.asesorias;

import pf.siga.model.asesorias.Asesorias;
import pf.siga.model.asesorias.asesoriasDao;
import pf.siga.model.users.usersBean;
import pf.siga.utils.resultAction;
import java.util.List;

public class serviceAsesorias {
    asesoriasDao daoAsesorias = new asesoriasDao();

    public Asesorias localizateEst() {return daoAsesorias.locateEst();}
    public Asesorias localizateDoc() {return daoAsesorias.locateDoc();}
    public List<Asesorias> getAll(){
        return daoAsesorias.findAll();
    }
    public List<Asesorias> getND(){return daoAsesorias.findND();}

    public List<Asesorias> getAllE(String username){
        return daoAsesorias.findAllE(username);
    }
    public List<Asesorias> getMaI(int id){return daoAsesorias.findMatIm(id);}
    public List<Asesorias> getSMaI(){return daoAsesorias.findAllM();}
    public List<Asesorias> getAllD(String username){return daoAsesorias.findAllD(username);}
    public List<Asesorias> getHisD(String username){return daoAsesorias.histoD(username);}
    public List<Asesorias> getMat(Asesorias newA){return daoAsesorias.getMaterias(newA);}
    public List<Asesorias> getP(int newA){return daoAsesorias.getprofes(newA);}
    public Asesorias getCu(String username){return daoAsesorias.findD(username);}
    public Asesorias getAseo(int id){return daoAsesorias.find(id);}
    public Asesorias getAs(){return daoAsesorias.findA();}

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

    public resultAction darPermiso(Asesorias add){
        resultAction result = new resultAction();
        if (daoAsesorias.permiso(add)){
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

    public resultAction cancel(Asesorias rechazar){
        resultAction result = new resultAction();
        if (daoAsesorias.cancelar(rechazar)){
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

    public resultAction delA(){
        resultAction result = new resultAction();
        if (daoAsesorias.delA()){
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

    public resultAction addMateria(Asesorias newA){
        resultAction result = new resultAction();
        if (daoAsesorias.matAse(newA)){
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

    public resultAction addDoc(Asesorias asesoria){
        resultAction result = new resultAction();
        if (daoAsesorias.addProfe(asesoria)){
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

    public resultAction addTema(Asesorias asesoria){
        resultAction result = new resultAction();
        if (daoAsesorias.addTemaDuda(asesoria)){
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

    public resultAction addMatI(Asesorias asesoria){
        resultAction result = new resultAction();
        if (daoAsesorias.addMAt(asesoria)){
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
