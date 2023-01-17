import getters from "@/store/authenticate/getters"
import actions from "@/store/authenticate/actions";
import mutations from "@/store/authenticate/mutations";
import state from "@/store/authenticate/state";

const authenticateModule = {
    namespaced: true,
    state:     state,
    getters:   getters,
    actions:   actions,
    mutations: mutations
}

export default authenticateModule