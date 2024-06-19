<template>
  <v-dialog max-width="500" v-model="dialog">
    <template v-slot:activator="{ props: activatorProps }">
      <v-btn
        v-bind="activatorProps"
        text="Novo"
        variant="flat"
        color="blue"
        prepend-icon="mdi-plus"
      >
        Novo
      </v-btn>
    </template>

    <template v-slot:default>
      <v-card class="border rounded-lg">
        <v-container>
          <v-card
            elevation="0"
            class="d-flex flex-row align-center justify-space-between"
          >
            <h2>Novo professor</h2>

            <v-btn
              elevation="0"
              density="compact"
              icon="mdi-close"
              @click="dialog = false"
            ></v-btn>
          </v-card>
        </v-container>

        <v-divider></v-divider>

        <v-card-text>
          <v-form ref="form" v-model="valid">
            <v-container>
              <v-row>
                <v-col cols="10">
                  <v-text-field
                    v-model="teacherImage"
                    label="Foto"
                    variant="outlined"
                    required
                  ></v-text-field>
                </v-col>
                <v-col class="d-flex justify-center align-start" cols="2">
                  <v-tooltip v-model="show" location="right">
                    <template v-slot:activator="{ props }">
                      <v-btn icon v-bind="props">
                        <v-icon col> mdi-information-outline </v-icon>
                      </v-btn>
                    </template>
                    <span>Insira o link da foto</span>
                  </v-tooltip>
                </v-col>
                <v-col cols="6">
                  <v-text-field
                    v-model="teacherFirstName"
                    label="Nome"
                    variant="outlined"
                    required
                  ></v-text-field>
                </v-col>

                <v-col cols="6">
                  <v-text-field
                    v-model="teacherLastName"
                    label="Sobrenome"
                    variant="outlined"
                    required
                  ></v-text-field>
                </v-col>

                <v-col cols="12">
                  <v-text-field
                    v-model="teacherEmail"
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
        <v-container>
          <v-card-actions class="d-flex justify-center">
            <v-btn
              variant="flat"
              prepend-icon="mdi-content-save"
              color="success"
              @click="save"
              >Salvar</v-btn
            >
          </v-card-actions>
        </v-container>
      </v-card>
    </template>
  </v-dialog>
</template>

<script>
import axios from "axios";
import emitter from "@/events/emiter.js";

export default {
  name: "VModalCreateTeacher",
  data() {
    return {
      dialog: false,
      valid: false,
      teacherImage: "",
      teacherFirstName: "",
      teacherLastName: "",
      teacherEmail: "",
    };
  },
  methods: {
    async save() {
      if (this.$refs.form.validate() && this.valid) {
        try {
          const response = await axios.post("http://localhost:8080/teacher", {
            teacherImage: this.teacherImage,
            teacherFirstName: this.teacherFirstName,
            teacherLastName: this.teacherLastName,
            teacherEmail: this.teacherEmail,
          });

          emitter.emit("newTeacherCreated", response.data);

          this.dialog = false;
          this.resetForm();
        } catch (error) {
          console.error("Erro ao salvar o professor", error);
        }
      } else {
        console.warn("O formulário não passou na validação");
      }
    },
    resetForm() {
      this.teacherImage = "";
      this.teacherFirstName = "";
      this.teacherLastName = "";
      this.teacherEmail = "";
      this.$refs.form.reset();
      this.$refs.form.resetValidation();
    },
  },
};
</script>
