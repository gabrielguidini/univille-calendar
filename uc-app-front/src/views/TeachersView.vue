<template>
  <v-main class="bg-grey-lighten-2">
    <v-container class="d-flex flex-column ga-5">
      <v-card flat class="rounded-lg">
        <v-card class="" color="grey-lighten-5">
          <v-card-actions
            class="d-flex justify-space-between align-center pa-2"
          >
            <v-card-title>Professores</v-card-title>
            <VModalCreateTeacher />
          </v-card-actions>
        </v-card>
      </v-card>

      <v-card flat class="rounded-lg bg-grey-lighten-5">
        <v-container>
          <v-row class="d-flex pa-9">
            <VTeachers />
          </v-row>
        </v-container>
      </v-card>
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

  data() {
    return {
      teachers: [],
    };
  },
};
</script>

<style></style>
