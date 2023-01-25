import http from "@/services/http-common";

class AuthenticateDataService {
    doLogin(loginRequest) {
        return http.post('/authenticate', {
            'email': loginRequest.email,
            'password': loginRequest.password,
        })
            .then(response => {
                if (response.data.accessToken) {
                    localStorage.setItem('user', JSON.stringify(response.data))
                }
                return response.data;
            });
    }

    doLogout() {
        localStorage.removeItem('user');
    }

    doRegister(registerRequest) {
        return http.post('/register', {
            'firstName': registerRequest.firstName,
            'lastName': registerRequest.lastName,
            'email': registerRequest.email,
            'password': registerRequest.password
        });
        /* return http.post('/register', {  body : JSON.stringify(registerRequest)});*/
    }

}

export default new AuthenticateDataService();

export class LoginRequest {
    constructor(email, password) {
        this.email = email;
        this.password = password;
    }
}

export class RegisterRequest {
    constructor(firstName, lastName, email, password) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}