import http from "@/services/http-common";

class AuthenticateDataService {
    doLogin(loginRequest) {
        return http.post('/auth/authenticate', loginRequest)
            .then(response => {
                if(response.data.accessToken){
                    localStorage.setItem('user', JSON.stringify(response.data))
                }
                return response.data;
            });
    }
    doLogout(){
        localStorage.removeItem('user');
    }

    doRegister(registerRequest) {
        return http.post('/auth/register', registerRequest);
    }

}

export default new AuthenticateDataService();

export class LoginRequest{
    constructor(email, password) {
        this.email = email;
        this.password = password;
    }
}

export class RegisterRequest{
    constructor(firstName, lastName, email, password) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}