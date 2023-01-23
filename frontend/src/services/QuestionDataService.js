import http from "../services/http-common"
import authHeader from "@/services/auth-header";

class QuestionDataService {
    getAllQuestions() {
        return http.get("/questions", {headers: authHeader()});
    }
}

export default new QuestionDataService();