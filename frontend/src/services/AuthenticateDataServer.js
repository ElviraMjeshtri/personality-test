import http from "@/services/http-common";

class AuthenticateDataService {
    doLogin(loginRequest) {
        return http.post('/auth/authenticate', loginRequest);
    }

    doRegister(registerRequest) {
        return http.post('/auth/register', registerRequest);
    }

}

export default new AuthenticateDataService();

class LoginRequest{
    constructor(email, password) {
        this.email = email;
        this.password = password;
    }
}

class RegisterRequest{
    constructor(firstName, lastName, email, password) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}