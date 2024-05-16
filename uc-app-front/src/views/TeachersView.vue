<template>
  <v-main>
    <v-container class="d-flex flex-column ga-5">
      <h1>Professores</h1>

      <v-card
        class="d-flex justify-start pa-2"
        color="transparent"
        elevation="0"
      >
      </v-card>

      <v-card class="d-flex justify-end pa-2" color="transparent" elevation="0">
        <VModalCreateTeacher />
      </v-card>

      <v-row>
        <VTeachers />
      </v-row>
    </v-container>
  </v-main>
</template>

<script>
import VTeachers from "../components/VTeachers.vue";
import VModalCreateTeacher from "../components/VModal/VModalCreateTeacher.vue";

export default {
  components: {
    VTeachers,
    VModalCreateTeacher,
  },
};
</script>

<style></style>
