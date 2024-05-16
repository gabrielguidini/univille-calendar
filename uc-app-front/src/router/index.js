import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import CoursesView from "@/views/CoursesView.vue";
import RoomsView from "@/views/RoomsView.vue";
import SchedulesView from "@/views/SchedulesView.vue";
import SubjectsView from "@/views/SubjectsView.vue";
import TeachersView from "@/views/TeachersView.vue";
import LoginView from "@/views/LoginView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "login",
      component: LoginView,
    },
    {
      path: "/home",
      name: "home",
      component: HomeView,
    },
    {
      path: "/courses",
      name: "courses",
      component: CoursesView,
    },
    {
      path: "/rooms",
      name: "rooms",
      component: RoomsView,
    },
    {
      path: "/scheadules",
      name: "scheadules",
      component: SchedulesView,
    },
    {
      path: "/subjects",
      name: "subjects",
      component: SubjectsView,
    },
    {
      path: "/teachers",
      name: "teachers",
      component: TeachersView,
    },
  ],
});

export default router;
