import getters from "@/store/quiz/getters"
import actions from "@/store/quiz/actions";
import mutations from "@/store/quiz/mutations";
import state from "@/store/quiz/state";

const quizModule = {
    namespaced: true,
    state:     state,
    getters:   getters,
    actions:   actions,
    mutations: mutations
}

export default quizModule