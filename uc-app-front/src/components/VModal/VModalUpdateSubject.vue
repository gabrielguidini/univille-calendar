<template>
	<v-dialog max-width="500" v-model="dialog">
		<template v-slot:activator="{ props: activatorProps }">
			<v-btn
				v-bind="activatorProps"
				density="compact"
				icon="mdi-pencil"
				size="large"
				color="primary">
			</v-btn>
		</template>

		<template v-slot:default>
			<v-card class="border">
				<v-container>
					<v-card
						elevation="0"
						class="d-flex flex-row align-center justify-space-between">
						<h2>Editar disciplina</h2>

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
										v-model="subjectName"
										:value="subjectName"
										label="Disciplina"
										variant="outlined"
										required></v-text-field>
								</v-col>
							</v-row>
							<v-row>
								<v-col cols="4">
									<!-- dia select -->
									<v-select
										label="Dia da semana"
										required
										v-model="selectedDayWeekEnum"
										:value="selectedDayWeekEnum"
										:items="dayWeekEnum"
										variant="outlined"></v-select>
								</v-col>

								<!-- inicio select -->
								<v-col cols="4">
									<v-select
										label="Início"
										required
										:value="selectedStartingTime"
										v-model="selectedStartingTime"
										:items="startingTime"
										variant="outlined"></v-select>
								</v-col>

								<!-- termino select -->
								<v-col cols="4">
									<v-select
										label="Término"
										required
										v-model="selectedEndingTime"
										:value="selectedEndingTime"
										:items="endingTime"
										variant="outlined"></v-select>
								</v-col>
							</v-row>

							<!-- professor select -->
							<v-row>
								<v-col cols="6">
									<v-select
										label="Nome do professor"
										v-model="selectedTeacherFirstName"
										:items="teacherFirstName"
										:value="selectedTeacherFirstName"
										required
										variant="outlined"></v-select>
								</v-col>

								<v-col cols="6">
									<v-select
										label="Sobrenome do professor"
										v-model="selectedTeacherLastName"
										:value="selectedTeacherLastName"
										:items="teacherLastName"
										required
										variant="outlined"></v-select>
								</v-col>
							</v-row>
							<v-row>
								<v-col cols="6">
									<v-form ref="form" v-model="valid">
										<v-text-field
											v-model="room"
											label="Sala"
											variant="outlined"
											required></v-text-field>
									</v-form>
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
							@click="save"
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
	name: "VModalUpdateSubject",
	emits: ["deleteSubjects", "editSubjectsSchedule", "editSubjectsTeacher"],
	props: {
		selectedSubject: Object,
	},
	data() {
		return {
			dialog: false,
			valid: false,
			teachers: [],
			selectedStartingTime: "",
			selectedEndingTime: "",
			selectedDayWeekEnum: "",
			selectedTeacherFirstName: "",
			selectedTeacherLastName: "",
			subjectName: "",
			teacherFirstName: "",
			teacherLastName: "",
			subjectId: "",
			room: "",
			days: [
				{ value: "Segunda-feira" },
				{ value: "Terça-feira" },
				{ value: "Quarta-feira" },
				{ value: "Quinta-feira" },
				{ value: "Sexta-feira" },
			],
		};
	},
	mounted() {
		this.subjectName = this.selectedSubject.subjectName;
		this.subjectId = this.selectedSubject.subjectId;

		this.getTeachers();
	},

	methods: {
		async save() {
			this.editSubject();
			this.editTeacher();

			this.resetForm();
		},

		deleteSubject() {
			this.$emit("deleteSubjects", this.subjectId);
			console.log("👉 this.subjectId => ", this.subjectId);

			this.dialog = false;
		},

		resetForm() {
			this.$refs.form.reset();
			this.$refs.form.resetValidation();
		},

		editSubject() {
			this.$emit("editSubjectsSchedule", {
				subjectId: this.subjectId,
				subjectName: this.subjectName,
				schedule: {
					dayWeekEnum: this.translateDayWeek(this.selectedDayWeekEnum),
					startingTime: this.selectedStartingTime,
					endingTime: this.selectedEndingTime,
					room: this.room,
				},
			});

			this.dialog = false;
		},

		editTeacher() {
			this.$emit("editSubjectsTeacher", {
				subjectId: this.subjectId,
				subjectName: this.subjectName,
				schedule: {
					dayWeekEnum: this.translateDayWeek(this.selectedDayWeekEnum),
					startingTime: this.selectedStartingTime,
					endingTime: this.selectedEndingTime,
					room: this.room,
				},
				teacher: {
					teacherFirstName: this.selectedTeacherFirstName,
					teacherLastName: this.selectedTeacherLastName,
				},
				course: {
					courseName: this.courseName,
					courseType: this.courseType,
				},
			});

			this.dialog = false;
		},

		getTeachers() {
			axios
				.get("http://localhost:8080/teacher/all")
				.then((response) => {
					this.teachers = response.data;

					this.teacherFirstName = this.teachers.map(
						(teacher) => teacher.teacherFirstName
					);

					this.teacherLastName = this.teachers.map(
						(teacher) => teacher.teacherLastName
					);
				})
				.catch((error) => {
					console.log(error);
				});
		},
		translateDayWeek(enumValue) {
			switch (enumValue) {
				case "Segunda-feira":
					return "MONDAY";
				case "Terça-feira":
					return "TUESDAY";
				case "Quarta-feira":
					return "WEDNESDAY";
				case "Quinta-feira":
					return "THURSDAY";
				case "Sexta-feira":
					return "FRIDAY";
				default:
					return enumValue;
			}
		},
	},

	computed: {
		dayWeekEnum() {
			return this.days.map((day) => day.value);
		},

		startingTime() {
			const times = [{ value: "18:50" }, { value: "20:50" }];
			return times.map((time) => time.value);
		},

		endingTime() {
			const times = [{ value: "20:50" }, { value: "22:30" }];
			return times.map((time) => time.value);
		},
	},
};
</script>

<style></style>
