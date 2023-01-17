import { createWebHistory, createRouter } from "vue-router";
import Home from "@/views/Home.vue";
import Results from "@/views/Results.vue";
import Quiz from "@/views/Quiz.vue";
import Login from "@/views/Login.vue";
import Register from "@/views/Register.vue";

const routes = [
    {
        path: "/",
        name: "Login",
        component: Login,
    },
    {
        path: "/register",
        name: "Register",
        component: Register,
    },
    {
        path: "/home",
        name: "Home",
        component: Home,
    },
    {
        path: "/quiz",
        name: "Quiz",
        component: Quiz,
    },
    {
        path: "/results",
        name: "Results",
        component: Results,
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;