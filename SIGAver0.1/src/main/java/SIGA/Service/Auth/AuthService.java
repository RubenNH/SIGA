package SIGA.Service.Auth;

import SIGA.Model.Auth.BeanUser;
import SIGA.Model.Auth.DaoAuth;

public class AuthService {

    DaoAuth auth = new DaoAuth();

    public BeanUser login(String username, String password) {
        return auth.validate(username, password);
    }
}
