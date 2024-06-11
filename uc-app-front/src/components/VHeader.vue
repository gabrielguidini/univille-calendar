<template>
	<v-navigation-drawer
		flat
		v-model="toggleMenu"
		color="grey-lighten-5"
		class="border-none">
		<v-list density="compact" nav>
			<v-list-item
				prepend-icon="mdi-home"
				title="Inicio"
				:to="{ name: 'home' }"></v-list-item>
			<v-list-item
				prepend-icon="mdi-book-open-variant"
				title="Cursos"
				:to="{ name: 'courses' }"></v-list-item>
			<v-list-item
				prepend-icon="mdi-calendar-clock"
				title="Horários"
				:to="{ name: 'scheadules' }"></v-list-item>
			<v-list-item
				prepend-icon="mdi-book-multiple"
				title="Disciplinas"
				:to="{ name: 'subjects' }"></v-list-item>
			<v-list-item
				prepend-icon="mdi-account-group"
				title="Professores"
				:to="{ name: 'teachers' }"></v-list-item>
		</v-list>
	</v-navigation-drawer>

	<v-app-bar flat color="grey-lighten-5">
		<v-app-bar-nav-icon @click="toggleMenu = !toggleMenu"> </v-app-bar-nav-icon>
		<v-app-bar-title>Univille Calendar</v-app-bar-title>
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

<style></style>
