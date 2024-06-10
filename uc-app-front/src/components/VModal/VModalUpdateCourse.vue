<template>
	<v-dialog max-width="500" v-model="dialog">
		<template v-slot:activator="{ props: activatorProps }">
			<v-btn
				v-bind="activatorProps"
				density="compact"
				icon="mdi-pencil"
				size="large"
				color="primary"
				@click="ainda">
			</v-btn>
		</template>

		<template v-slot:default>
			<v-card class="border">
				<v-container>
					<v-card
						elevation="0"
						class="d-flex flex-row align-center justify-space-between">
						<h2>Editar curso</h2>

						<v-btn
							elevation="0"
							density="compact"
							icon="mdi-close"
							size="large"
							@click="dialog = false"></v-btn>
					</v-card>
				</v-container>
				<v-divider></v-divider>

				<v-card-text>
					<v-form ref="form" v-model="valid">
						<v-container>
							<v-row>
								<v-col cols="12">
									<v-text-field
										label="Nome do curso"
										v-model="courseName"
										variant="outlined"
										required></v-text-field>
								</v-col>
								<v-col cols="12">
									<v-select
										label="Tipo do curso"
										:items="courseTypeList"
										item-text="text"
										item-value="value"
										v-model="courseType"
										variant="outlined"
										required></v-select>
								</v-col>
							</v-row>
						</v-container>
					</v-form>
				</v-card-text>

				<v-divider></v-divider>
				<v-container>
					<v-card-actions class="d-flex justify-center">
						<v-btn
							v-bind="activatorProps"
							variant="flat"
							prepend-icon="mdi-content-save"
							color="success"
							@click="edit"
							>Salvar</v-btn
						>
						<v-btn
							v-bind="activatorProps"
							variant="flat"
							color="error"
							prepend-icon="mdi-delete-forever"
							@click="deleteSubject"
							>Excluir</v-btn
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
	name: "VModalUpdateCourse",
	emits: ["updateCourse"],
	props: {
		selectedCourse: null,
	},
	data() {
		return {
			dialog: false,
			valid: false,
			courses: [],
			courseName: "",
			courseType: "",
			courseId: "",
			courseTypeList: ["Tecnólogo", "Bacharelado"],
		};
	},
	mounted() {
		this.courseId = this.selectedCourse.courseId;
		this.courseName = this.selectedCourse.courseName;
		this.courseType = this.translateCourseType(this.selectedCourse.courseType);
	},
	methods: {
		// async save() {
		// 	try {
		// 		console.log("courseType", this.courseType);
		// 		await axios.post("http://localhost:8080/course", {
		// 			courseName: this.courseName,
		// 			courseType: this.translateCourseTypeBack(this.courseType),
		// 		});

		// 		emitter.emit("updateCourses");

		// 		this.dialog = false;
		// 	} catch (error) {
		// 		console.error(error);
		// 	}
		// },

		translateCourseType(courseType) {
			return courseType === "COURSE_TYPE_BACHELOR"
				? "Bacharelado"
				: courseType === "COURSE_TYPE_TECHNICAL"
					? "Tecnólogo"
					: null;
		},

		translateCourseTypeBack(courseType) {
			return courseType === "Bacharelado"
				? "COURSE_TYPE_BACHELOR"
				: courseType === "Tecnólogo"
					? "COURSE_TYPE_TECHNICAL"
					: null;
		},

		shouldShowCourseType() {
			let a = this.courseType.map((course) => {
				return courseType === "COURSE_TYPE_BACHELOR"
					? "Bacharelado"
					: "Técnico";
			});
			return a;
		},

		async edit() {
			try {
				await axios.put(`http://localhost:8080/course/${this.courseId}`, {
					courseName: this.courseName,
					courseType: this.translateCourseTypeBack(this.courseType),
				});

				console.log("fez put");
				emitter.emit("updateCourses");

				this.dialog = false;
			} catch (error) {
				console.log(error);
			}
		},

		ainda() {
			console.log("👉 this.courseId => ", this.courseId);
		},
	},
};
</script>

<style></style>
