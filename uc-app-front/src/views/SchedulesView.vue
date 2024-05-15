<template>
  <v-col>
    <v-card>
      <v-card-title>Horários</v-card-title>
    </v-card>

    <v-card>
      <v-card-text>
        <VSchedules :tableHeight="400" />
      </v-card-text>
    </v-card>
  </v-col>
</template>

<script>
import VSchedules from '../components/VSchedules.vue'

export default {
  components: {
    VSchedules
  }
}
</script>

<style></style>
