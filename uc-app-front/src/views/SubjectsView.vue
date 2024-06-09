<template>
  <v-main class="bg-grey-lighten-2">
    <v-container class="d-flex flex-column ga-5">
      <v-card flat class="border rounded-lg">
        <v-card
          class="d-flex justify-space-between align-center pa-2"
          color="transparent"
          elevation="0"
        >
          <h1>Disciplinas</h1>
          <VModalCreateSubject />
        </v-card>
      </v-card>

      <v-card flat class="border rounded-lg">
        <v-container class="d-flex flex-column ga-5">
          <v-row class="pa-6">
            <VSubject />
          </v-row>
        </v-container>
      </v-card>
    </v-container>
  </v-main>
</template>

<script>
import VSubject from "@/components/VSubject.vue";
import VModalCreateSubject from "../components/VModal/VModalCreateSubject.vue";

export default {
  components: {
    VSubject,
    VModalCreateSubject,
  },
};
</script>

<style></style>
