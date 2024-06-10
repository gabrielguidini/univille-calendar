<template>
	<v-col>
		<v-table fixed-header class="border rounded-lg">
			<thead>
				<tr>
					<th class="text-left">Disciplina</th>
					<th class="text-left">Professor</th>
					<th class="text-left">Horário</th>
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
									{{ translateDayWeek(schedule.dayWeekEnum) }}
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
				})
				.catch((error) => {
					console.log(error);
				});
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
