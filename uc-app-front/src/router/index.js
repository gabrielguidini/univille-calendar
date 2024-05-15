import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import CoursesView from "../views/CoursesView.vue";
import RoomsView from "../views/RoomsView.vue";
import SchedulesView from "@/views/SchedulesView.vue";
import SubjectsView from "@/views/SubjectsView.vue";
import TeachersView from "@/views/TeachersView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
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
