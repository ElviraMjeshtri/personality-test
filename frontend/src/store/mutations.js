import {FETCH_QUESTION_LIST } from "./types";

const mutations = {
    [FETCH_QUESTION_LIST](state, payload) {
        state.questionDataList = payload.payload;
    }
};
export default mutations;