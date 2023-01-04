import { createApp } from 'vue'
import App from './App.vue'
import router from "@/router";
import './assets/main.css'
import VueAxios from "vue-axios";
import axios from "axios";


createApp(App)
    .use(router)
    .use(VueAxios, axios)
    .provide('axios', app.config.globalProperties.axios)
    .mount('#app')
