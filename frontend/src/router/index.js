import { createWebHistory, createRouter } from "vue-router";
import Home from "@/views/Home.vue";
import Results from "@/views/Results.vue";
import Questions from "@/views/Questions.vue";

const routes = [
    {
        path: "/",
        name: "Home",
        component: Home,
    },
    {
        path: "/questions",
        name: "Questions",
        component: Questions,
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