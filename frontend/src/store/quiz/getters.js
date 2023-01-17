import {GET_QUESTION_LIST} from "@/store/quiz/types";

export default {

    [GET_QUESTION_LIST]: (state) => {
        return state.questionDataList;
    }
}