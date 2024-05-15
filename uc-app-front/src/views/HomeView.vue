<template>
  <v-col class="container">
    <v-card-title class="text-h6 text-md-h5 text-lg-h4 text-black">Inicio</v-card-title>

    <v-card>
      <v-card-title>Cursos</v-card-title>
      <VCourses :tableHeight="250" />
    </v-card>

    <v-card>
      <v-card-title>Horários</v-card-title>
      <VSchedules :tableHeight="250" />
    </v-card>
  </v-col>
</template>

<script>
import VCourses from '@/components/VCourses.vue'
import VSchedules from '../components/VSchedules.vue'
import VTeachers from '../components/VTeachers.vue'

export default {
  components: {
    VCourses,
    VSchedules,
    VTeachers
  }
}
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  gap: 20px;
  padding: 10px;
  box-sizing: border-box;
  width: calc(100% - 255px);
  background-color: #e0e0e0;
}

.items {
  display: flex;
  flex-direction: column;
  gap: 5px;
  height: 100%;
  /* border: solid 1px red; */
}
h1,
h3 {
  color: var(--vt-c-black);

  font-weight: bold;
}
.dash-grid {
  display: grid;
  gap: 10px;

  grid-template-columns: 1fr;
  grid-template-rows: 1fr;
}
</style>
