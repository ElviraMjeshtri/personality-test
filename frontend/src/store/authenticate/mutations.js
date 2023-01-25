const mutations = {
    loginSuccess(state, user) {
        state.initialState.status.loggedIn = true;
        state.initialState.status.user = user;
    },
    loginFailure(state) {
        state.initialState.status.loggedIn = false;
        state.initialState.status.user = null;
    },
    logout(state) {
        state.initialState.status.loggedIn = false;
        state.initialState.status.user = null;
    },
    registerSuccess(state) {
        state.initialState.status.loggedIn = false;
    },
    registerFailure(state) {
        state.initialState.status.loggedIn = false;
    }
};
export default mutations;