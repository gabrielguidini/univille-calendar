<template>
  <v-dialog v-model="dialog" max-width="500px">
    <template v-slot:activator="{ on }">
      <slot name="activator" v-on="on"></slot>
    </template>
    <v-card>
      <v-card-title>{{ title }}</v-card-title>
      <v-card-text>
        <slot></slot>
      </v-card-text>
      <v-card-actions>
        <v-btn color="red-darken-1" @click="close">Fechar</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  props: {
    title: String
  },
  data() {
    return {
      dialog: false
    }
  },
  methods: {
    close() {
      this.dialog = false
    }
  }
}
</script>
