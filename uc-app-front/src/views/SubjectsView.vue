<template>
  <v-main>
    <v-container class="d-flex flex-column ga-5">
      <h1>Disciplinas</h1>

      <v-card
        class="d-flex justify-start pa-2"
        color="transparent"
        elevation="0"
      >
      </v-card>

      <v-card class="d-flex justify-end pa-2" color="transparent" elevation="0">
        <VModalCreateSubject />
      </v-card>

      <v-row>
        <VSubjects />
      </v-row>
    </v-container>
  </v-main>
</template>

<script>
import VSubjects from "../components/VSubjects.vue";
import VModalCreateSubject from "../components/VModal/VModalCreateSubject.vue";

export default {
  components: {
    VSubjects,
    VModalCreateSubject,
  },
};
</script>

<style></style>
