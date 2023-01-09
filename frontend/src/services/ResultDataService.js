import http from "../services/http-common"

class ResultDataService {
    getTestResult(results) {
        return http.get('/getResult/'+ results);
    }
}

export default new ResultDataService();