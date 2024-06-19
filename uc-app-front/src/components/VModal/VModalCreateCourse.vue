<template>
	<v-dialog max-width="500" v-model="dialog">
		<template v-slot:activator="{ props: activatorProps }">
			<v-btn
				v-bind="activatorProps"
				text="Novo"
				variant="flat"
				color="blue"
				prepend-icon="mdi-plus">
				Novo
			</v-btn>
		</template>

		<template v-slot:default>
			<v-card class="border rounded-lg">
				<v-container>
					<v-card
						elevation="0"
						class="d-flex flex-row align-center justify-space-between">
						<h2>Novo curso</h2>

						<v-btn
							elevation="0"
							density="compact"
							icon="mdi-close"
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
			courseName: "",
			courseType: "",
			courseTypeList: ["Tecnólogo", "Bacharelado"],
		};
	},
	methods: {
		async save() {
			try {
				await axios.post("http://localhost:8080/course", {
					courseName: this.courseName,
					courseType: this.translateCourseType(this.courseType),
				});

				emitter.emit("updateCourses");

				this.dialog = false;
			} catch (error) {
				console.error(error);
			}
		},

		shouldShowCourseType(courseType) {
			return courseType === "COURSE_TYPE_BACHELOR" ? "Bacharelado" : "Técnico";
		},

		translateCourseType(courseType) {
			return courseType === "Bacharelado"
				? "COURSE_TYPE_BACHELOR"
				: courseType === "Tecnólogo"
					? "COURSE_TYPE_TECHNICAL"
					: null;
		},
	},
};
</script>
