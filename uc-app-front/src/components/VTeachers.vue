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

      <v-card elevation="0">
        <template v-slot:title>
          {{ teacher.teacherFirstName }} {{ teacher.teacherLastName }}</template
        >

        <template v-slot:subtitle> {{ teacher.teacherEmail }} </template>

        <template v-slot:text>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Commodi,
          ratione debitis quis est labore voluptatibus!
        </template>
      </v-card>

      <v-divider></v-divider>

      <v-card-actions class="d-flex">
        <VModalUpdateTeacher
          :selectedTeacher="teacher"
          @deleteTeachers="deleteTeachers"
          @editTeachers="editTeachers"
        />
      </v-card-actions>
    </v-card>
  </v-col>
  <v-col cols="12" sm="6" md="4" lg="3" v-if="isLoading">
    <v-skeleton-loader
      class="mx-auto border"
      max-width="300"
      type="image, article, button"
    ></v-skeleton-loader>
  </v-col>
  <v-col cols="12" sm="6" md="4" lg="3" v-if="isLoading">
    <v-skeleton-loader
      class="mx-auto border"
      max-width="300"
      type="image, article, button"
    ></v-skeleton-loader>
  </v-col>
  <v-col cols="12" sm="6" md="4" lg="3" v-if="isLoading">
    <v-skeleton-loader
      class="mx-auto border"
      max-width="300"
      type="image, article, button"
    ></v-skeleton-loader>
  </v-col>
  <v-col cols="12" sm="6" md="4" lg="3" v-if="isLoading">
    <v-skeleton-loader
      class="mx-auto border"
      max-width="300"
      type="image, article, button"
    ></v-skeleton-loader>
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
      editSelectedTeacher: {},
      isLoading: false,
    };
  },
  mounted() {
    this.getTeachers();
  },
  methods: {
    getTeachers() {
      this.isLoading = true;
      setTimeout(() => {
        axios
          .get("http://localhost:8080/allTeachers")
          .then((response) => {
            this.teachers = response.data;
          })
          .catch((error) => {
            console.log(error);
          });
        this.isLoading = false;
      }, 1000);
    },
    deleteTeachers(Id) {
      axios
        .delete(`http://localhost:8080/${Id}`)
        .then((response) => {
          this.teachers = this.teachers.filter(
            (teacher) => teacher.teacherId !== Id
          );
        })
        .catch((error) => {
          console.log(error);
        });
    },

    editTeachers(teacherParams) {
      axios
        .put(`http://localhost:8080/updateTeacher/${teacherParams.teacherId}`, {
          teacherFirstName: teacherParams.teacherFirstName,
          teacherLastName: teacherParams.teacherLastName,
          teacherEmail: teacherParams.teacherEmail,
        })
        .then((response) => {
          const teacherFound = this.teachers.find(
            (teacher) => teacherParams.teacherId === teacher.teacherId
          );

          if (teacherFound) {
            teacherFound.teacherFirstName = teacherParams.teacherFirstName;
            teacherFound.teacherLastName = teacherParams.teacherLastName;
            teacherFound.teacherEmail = teacherParams.teacherEmail;
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
