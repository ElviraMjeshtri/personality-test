import http from "../services/http-common"

class QuestionDataService {
    getAllQuestions() {
        return http.get("/personalityTest/questions");
    }
}

export default new QuestionDataService();