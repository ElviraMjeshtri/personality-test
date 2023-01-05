import http from "../services/http-common"

class QuestionDataService {
    getAllQuestions() {
        return http.get("/listQuestions");
    }
}

export default new QuestionDataService();