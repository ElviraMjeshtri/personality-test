import { createStore } from 'vuex'

// use in createStore()
import quiz from './quiz/index'
import authenticate from './authenticate/index'

const store = createStore({
    modules: {
        quiz,
        authenticate
    }
})

// export store to use in main.js
export default store