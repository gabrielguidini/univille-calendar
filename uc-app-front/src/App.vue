<template>
  <v-app theme="light">
    <VHeader />
    <router-view> </router-view>
  </v-app>
</template>

<script>
import VTeachers from "./components/VTeachers.vue";
import VHeader from "./components/VHeader.vue";

export default {
  name: "App",
  components: {
    VTeachers,
    VHeader,
  },
  data() {
    return {};
  },
};
</script>

<style>
</style>
