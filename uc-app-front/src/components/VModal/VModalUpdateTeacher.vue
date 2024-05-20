<template>
  <v-dialog max-width="500" v-model="dialog">
    <template v-slot:activator="{ props: activatorProps }">
      <v-btn
        v-bind="activatorProps"
        variant="flat"
        color="primary"
        prepend-icon="mdi-pencil"
      >
        Editar
      </v-btn>
    </template>

    <template v-slot:default>
      <v-card>
        <v-card-title>Editar professor</v-card-title>
        <v-divider></v-divider>

        <v-card-text>
          <v-form ref="form" v-model="valid">
            <v-container>
              <v-row>
                <v-col cols="6">
                  <v-text-field
                    v-model="teacherFirstName"
                    :counter="10"
                    :rules="nameRules"
                    label="Nome"
                    variant="outlined"
                    required
                  ></v-text-field>
                </v-col>

                <v-col cols="6">
                  <v-text-field
                    v-model="teacherLastName"
                    :counter="10"
                    :rules="nameRules"
                    label="Sobrenome"
                    variant="outlined"
                    required
                  ></v-text-field>
                </v-col>

                <v-col cols="12">
                  <v-text-field
                    v-model="teacherEmail"
                    :rules="emailRules"
                    label="E-mail"
                    variant="outlined"
                    required
                  ></v-text-field>
                </v-col>
              </v-row>
            </v-container>
          </v-form>
        </v-card-text>

        <v-divider></v-divider>
        <v-card-actions class="d-flex justify-space-between pl-10 pr-10">
          <v-btn
            v-bind="activatorProps"
            variant="flat"
            color="success"
            prepend-icon="mdi-content-create"
            @click="edit"
            >Atualizar</v-btn
          >
          <v-btn
            v-bind="activatorProps"
            variant="flat"
            color="error"
            prepend-icon="mdi-delete-forever"
            @click="remover"
            >Excluir</v-btn
          >

          <v-btn
            v-bind="activatorProps"
            variant="flat"
            color="warning"
            prepend-icon="mdi-close"
            @click="dialog = false"
            >Fechar</v-btn
          >
        </v-card-actions>
      </v-card>
    </template>
  </v-dialog>
</template>

<script>
import axios from "axios";

export default {
  name: "VModalUpdateTeacher",
  emits: ["deleteTeachers", "editTeachers"],
  props: {
    selectedTeacher: Object,
  },
  data() {
    return {
      dialog: false,
      valid: false,
      teacherFirstName: "",
      teacherLastName: "",
      teacherEmail: "",
      nameRules: [
        (v) => !!v || "Nome é obrigatório",
        (v) => (v && v.length <= 10) || "Nome deve ter no máximo 10 caracteres",
      ],
      emailRules: [
        (v) => !!v || "E-mail é obrigatório",
        (v) => /.+@.+\..+/.test(v) || "E-mail deve ser válido",
      ],
    };
  },
  mounted() {
    this.teacherFirstName = this.selectedTeacher.teacherFirstName;
    this.teacherLastName = this.selectedTeacher.teacherLastName;
    this.teacherEmail = this.selectedTeacher.teacherEmail;
    this.teacherId = this.selectedTeacher.teacherId;
  },
  methods: {
    remover() {
      this.$emit("deleteTeachers", this.teacherId);

      this.dialog = false;
    },

    edit() {
      this.$emit("editTeachers", {
        teacherId: this.teacherId,
        teacherFirstName: this.teacherFirstName,
        teacherLastName: this.teacherLastName,
        teacherEmail: this.teacherEmail,
      });

      this.dialog = false;
    },
  },
};
</script>

<style></style>
