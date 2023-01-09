import {
    FETCH_QUESTION_LIST,
    FETCH_SELECTED_ANSWERS,
    FETCH_IS_TEST_COMPLETED,
    FETCH_CURRENT_QUESTION_INDEX, FETCH_IS_ANSWER_SELECTED, FETCH_TEST_RESULT, RESET_STATE
} from "./types";
function initialState() {
    return {
        questionDataList: [],
        selectedAnswers: [],
        isTestCompleted : false,
        currentQuestionIndex : 0,
        isAnswerSelected: false,
        result: []
    };
}

const mutations = {
    [FETCH_QUESTION_LIST](state, payload) {
        state.questionDataList = payload.payload;
    },
    [FETCH_SELECTED_ANSWERS](state, payload) {
        state.selectedAnswers = payload.value;
    },
    [FETCH_IS_TEST_COMPLETED](state, payload) {
        state.isTestCompleted = payload;
    },
    [FETCH_CURRENT_QUESTION_INDEX](state, payload) {
        state.currentQuestionIndex = payload;
    },
    [FETCH_IS_ANSWER_SELECTED](state, payload) {
        state.isAnswerSelected = payload;
    },
    [FETCH_TEST_RESULT](state, payload) {
        state.result = payload.payload;
    },

    [RESET_STATE](state) {
        Object.assign(state, initialState())
    },


};
export default mutations;