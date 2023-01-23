
import {
    DO_LOGIN,
    DO_LOGOUT,
    DO_REGISTER,
    LOGIN_FAILURE,
    LOGIN_SUCCESS,
    LOGOUT, REGISTER_FAILURE,
    REGISTER_SUCCESS
} from "@/store/authenticate/types";
import AuthenticateDataServer from "@/services/AuthenticateDataServer";


export default {
    async [DO_LOGIN]({commit}, payload) {
        try {
            let data = [];
            let response = await AuthenticateDataServer.doLogin(payload)
            data = response.data;
            commit(LOGIN_SUCCESS, {payload: data});
        } catch (error) {
            commit(LOGIN_FAILURE, {payload: []});
        }
    },

    async [DO_REGISTER]({commit}, payload) {
        try {
            let data = [];
            let response = await AuthenticateDataServer.doRegister(payload)
            data = response.data;
            commit(REGISTER_SUCCESS, {payload: data});
        } catch (error) {
            commit(REGISTER_FAILURE, {payload: []});
        }
    },
    async [DO_LOGOUT]({commit}) {
       AuthenticateDataServer.doLogout()
        commit(LOGOUT);
    },

}