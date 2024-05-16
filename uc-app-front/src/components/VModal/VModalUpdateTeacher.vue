<template>
  <v-dialog max-width="500" v-model="dialog">
    <template v-slot:activator="{ props: activatorProps }">
      <v-btn
        v-bind="activatorProps"
        variant="flat"
        color="primary"
        prepend-icon="mdi-pencil"
        @click="selectedTeacher(teacher)"
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
                    required
                  ></v-text-field>
                </v-col>

                <v-col cols="6">
                  <v-text-field
                    v-model="teacherLastName"
                    :counter="10"
                    :rules="nameRules"
                    label="Sobrenome"
                    required
                  ></v-text-field>
                </v-col>

                <v-col cols="12">
                  <v-text-field
                    v-model="teacherEmail"
                    :rules="emailRules"
                    label="E-mail"
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
            prepend-icon="mdi-content-save"
            @click="save"
            >Atualizar</v-btn
          >
          <v-btn
            v-bind="activatorProps"
            variant="flat"
            color="error"
            prepend-icon="mdi-delete-forever"
            @click="dialog = false"
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
  props: {
    selectedTeacher: Object,
    teacherFirstName: String,
    teacherLastName: String,
    teacherEmail: String,
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
  methods: {
    async save() {
      if (this.$refs.form.validate() && this.valid) {
        try {
          const response = await axios.put(
            "http://localhost:8080/createTeacher",
            {
              teacherFirstName: this.teacherFirstName,
              teacherLastName: this.teacherLastName,
              teacherEmail: this.teacherEmail,
            }
          );

          this.$emit("show-snackbar");

          this.dialog = false;
        } catch (error) {}
      }
    },
  },
};
</script>

<style></style>
