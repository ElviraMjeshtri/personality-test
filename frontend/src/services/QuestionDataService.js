import http from "../services/http-common"

class QuestionDataService {
    getAllQuestions() {
        return http.get("/tutorials");
    }
}

export default new QuestionDataService();