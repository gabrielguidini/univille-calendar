<script setup></script>

<template>
  <v-card>
    <v-layout>
      <!-- <v-navigation-drawer expand-on-hover rail disable-resize-watcher color="light-green-darken-1"> -->
      <v-navigation-drawer disable-resize-watcher color="light-green-darken-1">
        <v-list>
          <v-list-item
            prepend-avatar="https://media.licdn.com/dms/image/D4D03AQGYoQ8J6bk_5g/profile-displayphoto-shrink_800_800/0/1693415798903?e=1720656000&v=beta&t=TB7C-Xrs39L5qPaJ8wbvWDQr1bfHthPOTZ3XyxRxKkE"
            subtitle="leandropinheirorosa1@hotmail.com"
            title="Leandro Pinheiro"
          ></v-list-item>
        </v-list>

        <v-divider></v-divider>

        <v-list density="compact" nav>
          <v-list-item
            prepend-icon="mdi-home"
            title="Inicio"
            :to="{ name: 'home' }"
          ></v-list-item>
          <v-list-item
            prepend-icon="mdi-book-open-variant"
            title="Cursos"
            :to="{ name: 'courses' }"
          ></v-list-item>
          <v-list-item
            prepend-icon="mdi-map-marker"
            title="Salas"
            :to="{ name: 'rooms' }"
          ></v-list-item>
          <v-list-item
            prepend-icon="mdi-calendar-clock"
            title="Horários"
            :to="{ name: 'scheadules' }"
          ></v-list-item>
          <v-list-item
            prepend-icon="mdi-book-multiple"
            title="Disciplinas"
            :to="{ name: 'subjects' }"
          ></v-list-item>
          <v-list-item
            prepend-icon="mdi-account-group"
            title="Professores"
            :to="{ name: 'teachers' }"
          ></v-list-item>
        </v-list>
      </v-navigation-drawer>

      <v-main style="height: 250px"></v-main>
    </v-layout>
  </v-card>
</template>

<style scoped></style>
