<template>
  <v-navigation-drawer flat v-model="toggleMenu" class="border">
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

  <v-app-bar flat class="border-b">
    <v-app-bar-nav-icon @click="toggleMenu = !toggleMenu"> </v-app-bar-nav-icon>
    <v-app-bar-title>Univille Calendar</v-app-bar-title>

    <template #append>
      <v-btn icon class="mr-2">
        <v-badge content="10" color="info">
          <v-icon icon="mdi-bell-outline"></v-icon>
        </v-badge>
      </v-btn>
      <v-list width="200">
        <v-list-item
          prepend-avatar="https://media.licdn.com/dms/image/D4D03AQGYoQ8J6bk_5g/profile-displayphoto-shrink_800_800/0/1693415798903?e=1720656000&v=beta&t=TB7C-Xrs39L5qPaJ8wbvWDQr1bfHthPOTZ3XyxRxKkE"
          subtitle="leandropinheirorosa1@hotmail.com"
          title="Leandro Pinheiro"
        ></v-list-item>
      </v-list>
    </template>
  </v-app-bar>
</template>

<script>
export default {
  data() {
    return {
      toggleMenu: false,
    };
  },
};
</script>
