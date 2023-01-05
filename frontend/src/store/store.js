
import { createStore, createLogger } from 'vuex'
import getters from "@/store/getters"
import actions from "@/store/actions";
import mutations from "@/store/mutations";
import state from "@/store/state";

export default createStore({
    state,
    getters,
    actions,
    mutations,
    plugins: process.env.NODE_ENV !== 'production'
        ? [createLogger()]
        : []
})