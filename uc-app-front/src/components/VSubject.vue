<template>
	<v-col>
		<v-table fixed-header class="border rounded-lg">
			<thead>
				<tr>
					<th class="text-left">Disciplina</th>
					<th class="text-left">Professor</th>
					<th class="text-left">Horário</th>
					<th class="text-left">Sala</th>
					<th class="text-left">Editar</th>
				</tr>
			</thead>
			<tbody>
				<tr v-for="(subject, index) in subjects" :key="index">
					<td>{{ subject.subjectName }}</td>
					<td>
						{{
							subject.teacher
								? `${subject.teacher.teacherFirstName} ${subject.teacher.teacherLastName}`
								: "Nenhum professor cadastrado"
						}}
					</td>
					<td>
						<v-list v-if="subject.schedules.length > 0">
							<v-list-item
								v-for="schedule in subject.schedules"
								:key="schedule.scheduleId">
								<v-list-item-title>
									{{ `${translateDayWeek(schedule.dayWeekEnum)}` }}
								</v-list-item-title>

								<v-list-item-subtitle>
									{{ schedule.startingTime + " - " + schedule.endingTime }}
								</v-list-item-subtitle>
							</v-list-item>
						</v-list>
						<v-list v-else>
							<v-list-item>
								<v-item-subtitle> Nenhum horário disponível </v-item-subtitle>
							</v-list-item>
						</v-list>
					</td>
					<td>
						<v-list-item
							v-for="schedule in subject.schedules"
							:key="schedule.scheduleId">
							<v-list-item-title>
								{{ schedule.room }}
							</v-list-item-title>
						</v-list-item>
					</td>
					<td>
						<VModalUpdateSubject
							:selectedSubject="subject"
							@editSubjectsSchedule="editSubjectsSchedule"
							@editSubjectsTeacher="editSubjectsTeacher"
							@deleteSubjects="deleteSubjects" />
					</td>
				</tr>
			</tbody>
		</v-table>
	</v-col>
</template>

<script>
import VModalUpdateSubject from "./VModal/VModalUpdateSubject.vue";
import axios from "axios";
import emitter from "@/events/emiter.js";

export default {
	name: "VSubject",
	components: {
		VModalUpdateSubject,
	},
	data() {
		return {
			subjectId: "",
			subjectName: "",
			teacherFirstName: "",
			teacherLastName: "",
			teacherEmail: "",
			teachers: [],
			subjects: [],
			courses: [],
			courseName: "",
			courseType: "",
		};
	},
	mounted() {
		this.getSubjects();

		emitter.on("getSubjects", () => {
			console.log("chegou evento subjects");
			this.getSubjects();
		});
	},

	created() {
		this.emitter.on("newSubjectCreated", (response) => {
			// this.testEvent = response.eventContent;
			console.log("👉 response => ", response);
			this.subjects.push(response.data);
		});

		this.emitter.on("newSubjectEdited", (response) => {
			// this.testEvent = response.eventContent;
			console.log("👉 response => ", response);
			this.subjects.push(response.data);
		});
	},
	methods: {
		async getSubjects() {
			await axios
				.get("http://localhost:8080/subject/all")
				.then((response) => {
					this.subjects = response.data;

					console.log(response.data);
				})
				.catch((error) => {
					console.log(error);
				});
		},

		deleteSubjects(Id) {
			axios
				.delete(`http://localhost:8080/subject/${Id}`)
				.then((response) => {
					this.subjects = this.subjects.filter(
						(subject) => subject.subjectId !== Id
					);
				})
				.catch((error) => {
					console.log(error);
					console.log("👉 Eu tenteeei");
				});
		},

		async editSubjectsSchedule(subjectParams) {
			console.log("entrou no put schedule");
			await axios
				.put(
					`http://localhost:8080/subject/schedule/${subjectParams.subjectId}`,
					{
						dayWeekEnum: subjectParams.schedule.dayWeekEnum,
						startingTime: subjectParams.schedule.startingTime,
						endingTime: subjectParams.schedule.endingTime,
						room: subjectParams.schedule.room,
					}
				)

				.catch((error) => {
					console.log(error);
				});
		},

		async editSubjectsTeacher(subjectParams) {
			await axios
				.put(
					`http://localhost:8080/subject/teacher/${subjectParams.subjectId}?teacherFirstName=${subjectParams.teacher.teacherFirstName}&teacherLastName=${subjectParams.teacher.teacherLastName}`,
					{}
				)
				.catch((error) => {
					console.log(error);
				});

			emitter.emit("getSubjects");
		},

		translateDayWeek(enumValue) {
			switch (enumValue) {
				case "MONDAY":
					return "Segunda-feira";
				case "TUESDAY":
					return "Terça-feira";
				case "WEDNESDAY":
					return "Quarta-feira";
				case "THURSDAY":
					return "Quinta-feira";
				case "FRIDAY":
					return "Sexta-feira";
				case "SATURDAY":
					return "Sábado";
				case "SUNDAY":
					return "Domingo";
				default:
					return enumValue;
			}
		},
	},
};
</script>

<style>
@media screen and (max-width: 600px) {
	.table-header {
		display: none;
	}
}
</style>
