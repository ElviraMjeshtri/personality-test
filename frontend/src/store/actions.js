import QuestionDataService from "@/services/QuestionDataService";
import {
    FETCH_QUESTION_LIST, FETCH_TEST_RESULT
} from "./types";
import ResultDataService from "@/services/ResultDataService";

export default {
    async [FETCH_QUESTION_LIST]({commit}) {
        try {
            let data = [];
            let response = await QuestionDataService.getAllQuestions();
            data = response.data;
            commit(FETCH_QUESTION_LIST, {payload: data});
        } catch (error) {
            commit(FETCH_QUESTION_LIST, {payload: []});
        }
    },

    async [FETCH_TEST_RESULT]({commit}, payload) {
        try {
            let data = [];
            let response = await ResultDataService.getTestResult(payload);
            data = response.data;
            commit(FETCH_TEST_RESULT, {payload: data});
        } catch (error) {
            commit(FETCH_TEST_RESULT, {payload: []});
        }
    },

}