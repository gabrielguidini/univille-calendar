<template>
  <v-row>
    <v-col
      cols="12"
      xl="2"
      lg="3"
      md="4"
      sm="4"
      v-for="(teacher, index) in teachers"
      :key="index"
    >
      <v-card flat class="rounded-lg bg-white" elevation="3">
        <v-img :src="teacher.teacherImage"></v-img>

        <v-card elevation="0" color="transparent">
          <template v-slot:title>
            {{ teacher.teacherFirstName }} {{ teacher.teacherLastName }}
          </template>
          <template v-slot:subtitle>
            {{ teacher.teacherEmail }}
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

    <v-col cols="12" xl="2" lg="3" md="4" sm="4" v-if="isLoading">
      <v-skeleton-loader
        class="border"
        type="image, article, button"
        elevation="2"
      ></v-skeleton-loader>
    </v-col>
    <!-- Repita o skeleton-loader conforme necessário -->
  </v-row>
</template>

<script>
import axios from "axios";
import VModalUpdateTeacher from "./VModal/VModalUpdateTeacher.vue";
import emitter from "@/events/emiter.js";

export default {
  name: "VTeachers",
  components: {
    VModalUpdateTeacher,
  },
  data() {
    return {
      teachers: [],
      isLoading: false,
    };
  },

  mounted() {
    this.getTeachers();

    emitter.on("newTeacherCreated", (teacher) => {
      this.teachers.push(teacher);
    });
  },
  methods: {
    getTeachers() {
      this.isLoading = true;

      setTimeout(() => {
        axios
          .get("http://localhost:8080/teacher/all")
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
        .delete(`http://localhost:8080/teacher/${Id}`)
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
        .put(`http://localhost:8080/teacher/${teacherParams.teacherId}`, {
          teacherImage: teacherParams.teacherImage,
          teacherFirstName: teacherParams.teacherFirstName,
          teacherLastName: teacherParams.teacherLastName,
          teacherEmail: teacherParams.teacherEmail,
        })
        .then((response) => {
          const teacherFound = this.teachers.find(
            (teacher) => teacherParams.teacherId === teacher.teacherId
          );

          if (teacherFound) {
            teacherFound.teacherImage = teacherParams.teacherImage;
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
