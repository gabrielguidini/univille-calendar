<!-- <template>
  <v-card>
    <v-card-title>Professores</v-card-title>
    <v-card></v-card>
  </v-card>
  <v-table height="100">
    <thead class="thead-table">
      <tr>
        <th class="text-left">Discplina</th>
        <th class="text-left">Hora Aula</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(teacher, index) in this.teachers" :key="index">
        <td>{{ teacher.teacherFirstName }} {{ teacher.teacherLastName }}</td>
        <td>{{ teacher.teacherEmail }}</td>
      </tr>
    </tbody>
  </v-table>
</template> -->

<template>
  <div class="container" v-for="(teacher, index) in this.teachers" :key="index">
    <v-card width="250">
      <v-img
        class="align-end text-white"
        height="200"
        src="https://pbs.twimg.com/profile_images/1450817790022144008/MmPArZ2C_400x400.jpg"
        cover
      >
      </v-img>

      <v-card-text>
        <v-card-title
          >{{ teacher.teacherFirstName }}
          {{ teacher.teacherLastName }}</v-card-title
        >
        <v-card-subtitle>{{ teacher.teacherEmail }}</v-card-subtitle>
        <v-card-subtitle>ainda</v-card-subtitle>
      </v-card-text>
    </v-card>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "VTeachers",
  data() {
    return {
      teachers: [],
    };
  },
  mounted() {
    this.getTeachers();
  },
  methods: {
    getTeachers() {
      axios
        .get("http://localhost:8080/allTeachers")
        .then((res) => {
          this.teachers = res.data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style scoped></style>
