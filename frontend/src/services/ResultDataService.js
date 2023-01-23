import http from "../services/http-common"
import authHeader from "@/services/auth-header";

class ResultDataService {
    getTestResult(results) {
        return http.get('/personalityTest/getResult/'+ results, {headers: authHeader()});
    }
}

export default new ResultDataService();