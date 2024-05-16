<template>
  <v-app theme="dark">
    <VHeader v-if="isLogged" />
    <router-view></router-view>
  </v-app>
</template>

<script>
import VTeachers from "./components/VTeachers.vue";
import VHeader from "./components/VHeader.vue";

export default {
  components: {
    VTeachers,
    VHeader,
  },
  data() {
    return {
      isLogged: this.$store.state.isLogged,
    };
  },
};
</script>

<style></style>
