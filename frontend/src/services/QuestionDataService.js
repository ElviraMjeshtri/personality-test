import http from "../services/http-common"

class QuestionDataService {
    getAll() {
        return http.get("/tutorials");
    }
}

export default new QuestionDataService();