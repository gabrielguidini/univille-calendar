<template>
  <div class="pa-4 text-center">
    <v-dialog v-model="dialog" max-width="600">
      <template v-slot:activator="{ props: activatorProps }">
        <v-btn
          class="text-none font-weight-regular"
          prepend-icon="mdi-plus"
          text="Novo"
          v-bind="activatorProps"
          color="light-green-darken-1"
        ></v-btn>
      </template>

      <v-card prepend-icon="mdi-book-open-variant" title="Novo Curso">
        <v-card-text>
          <v-row dense>
            <v-col>
              <v-text-field label="Nome" required></v-text-field>
            </v-col>
          </v-row>
        </v-card-text>

        <v-divider></v-divider>

        <v-card-actions>
          <v-spacer></v-spacer>

          <v-btn text="Fechar" variant="plain" @click="dialog = false"></v-btn>

          <v-btn color="primary" text="Salvar" variant="tonal" @click="dialog = false"></v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>
<script>
export default {
  data: () => ({
    dialog: false
  })
}
</script>
