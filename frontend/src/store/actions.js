import QuestionDataService from "@/services/QuestionDataService";
import {
    FETCH_QUESTION_LIST
} from "./types";

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
}