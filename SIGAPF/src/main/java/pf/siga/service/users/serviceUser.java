package pf.siga.service.users;

import pf.siga.model.users.*;
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

}
