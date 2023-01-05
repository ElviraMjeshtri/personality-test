import {GET_QUESTION_LIST} from "@/store/types";

export default {

    [GET_QUESTION_LIST]: (state) => {
        return state.questionDataList;
    }
}