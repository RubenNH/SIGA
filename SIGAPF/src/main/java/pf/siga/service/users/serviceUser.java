package pf.siga.service.users;

import pf.siga.model.asesorias.Asesorias;
import pf.siga.model.users.*;
import pf.siga.utils.emailService;
import pf.siga.utils.resultAction;
import pf.siga.utils.requestFilter;

public class serviceUser {
    usersDao auth = new usersDao();

    public usersBean login(String username, String password) {
        return auth.validate(username, password);
    }

    public usersBean localizateE() {
        return auth.locateE();
    }
    public usersBean localizateU(String username) {return auth.locateU(username);}
    public usersBean localizateD() {return auth.locateD();}
    public usersBean AdminControl() {return auth.controlA();}

    public resultAction saveU(usersBean add){
        resultAction result = new resultAction();
        if (auth.saveUser(add)){
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

    public resultAction saveD(usersBean add){
        resultAction result = new resultAction();
        if (auth.saveDoc(add)){
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

    public resultAction saveE(usersBean add){
        resultAction result = new resultAction();
        if (auth.saveEst(add)){
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
    public void sendEmail(String username){
        if (auth.verifyUser(username)){
            new emailService().sendEmail(username);
        }
    }
}
