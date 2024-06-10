<template>
	<v-row>
		<v-col cols="12" md="6" v-for="(course, index) in courses" :key="index">
			<v-card class="mx-auto">
				<template v-slot:prepend>
					<v-avatar color="">
						<v-icon icon="mdi-book"></v-icon>
					</v-avatar>
					<v-col>
						<v-card-title>{{ course.courseName }}</v-card-title>
						<v-card-subtitle>{{
							translateCourseType(course.courseType)
						}}</v-card-subtitle>
					</v-col>
				</template>
				<template v-slot:append>
					<v-col>
						<VModalUpdateCourse :selectedCourse="course" />
					</v-col>
				</template>
			</v-card>
		</v-col>
	</v-row>
</template>

<script>
import axios from "axios";
import emitter from "@/events/emiter.js";
import VModalUpdateSubject from "@/components/VModal/VModalUpdateCourse.vue";
import VModalUpdateCourse from "@/components/VModal/VModalUpdateCourse.vue";

export default {
	name: "VCourses",
	components: {
		VModalUpdateCourse,
	},
	data() {
		return {
			courses: [], // Aqui são armazenados todos os cursos obtidos da API
			isLoading: false,
		};
	},

	mounted() {
		this.getCourses();

		emitter.on("updateCourses", () => {
			this.getCourses();
		});
	},

	methods: {
		getCourses() {
			axios
				.get("http://localhost:8080/course/all")
				.then((response) => {
					this.courses = response.data; // Aqui atribuímos os cursos obtidos da API à variável `courses`

					console.log("👉 response => ", response);
				})

				.catch((error) => {
					console.log(error);
				});
		},

		// updateCourse(courseParams) {
		// 	axios
		// 		.put(`http://localhost:8080/course/${courseParams.courseId}`, {
		// 			courseName: courseParams.course.courseName,
		// 			courseType: courseParams.course.courseType,
		// 		})

		// 		.catch((error) => {
		// 			console.log(error);
		// 		});
		// },

		translateCourseType(courseType) {
			return courseType === "COURSE_TYPE_BACHELOR"
				? "Bacharelado"
				: courseType === "COURSE_TYPE_LICENTIATE"
					? "Licenciatura"
					: courseType === "COURSE_TYPE_TECHNICAL"
						? "Tecnólogo"
						: null;
		},
	},
};
</script>

<style scoped></style>
