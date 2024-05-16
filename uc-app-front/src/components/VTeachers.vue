<template>
  <v-col
    cols="12"
    sm="6"
    md="4"
    lg="3"
    v-for="(teacher, index) in this.teachers"
    :key="index"
  >
    <v-card flat class="border rounded-lg">
      <v-img
        src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"
      >
      </v-img>

      <v-card-title
        >{{ teacher.teacherFirstName }}
        {{ teacher.teacherLastName }}</v-card-title
      >
      <v-card-subtitle>{{ teacher.teacherEmail }}</v-card-subtitle>

      <v-divider></v-divider>

      <v-card-actions class="d-flex justify-end">
        <VModalUpdateTeacher />
      </v-card-actions>
    </v-card>
  </v-col>
</template>

<script>
import axios from "axios";

import VModalUpdateTeacher from "./VModal/VModalUpdateTeacher.vue";

export default {
  name: "VTeachers",
  components: {
    VModalUpdateTeacher,
  },
  data() {
    return {
      teachers: [],
      EditSelectedTeacher: {},
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
    selectedTeacher(teacher) {
      this.EditSelectedTeacher = teacher;
    },
  },
};
</script>
