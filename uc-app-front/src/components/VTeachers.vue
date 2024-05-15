<template>
  <h1>teacher</h1>
  <v-table height="">
    <thead class="thead-table">
      <tr>
        <th class="text-left">Discplina</th>
        <th class="text-left">Hora Aula</th>
        <!-- <th class="button-container text-left"></th> -->
      </tr>
    </thead>
    <tbody>
      <tr v-for="(teacher, index) in this.teachers" :key="index">
        <td>{{ teacher.teacherFirstName }} {{ teacher.teacherLastName }}</td>
        <td>{{ teacher.teacherEmail }}</td>
      </tr>
    </tbody>
  </v-table>
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
          console.log("👉 this.teachers => ", this.teachers);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style scoped>
h1,
p {
  color: black;
}
</style>
