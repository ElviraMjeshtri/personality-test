import http from "../services/http-common"

class QuestionDataService {
    getAllQuestions() {
        return http.get("/questions");
    }
}

export default new QuestionDataService();