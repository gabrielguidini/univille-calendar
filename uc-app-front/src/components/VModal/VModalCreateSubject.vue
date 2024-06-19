<template>
	<v-dialog max-width="500" v-model="dialog">
		<template v-slot:activator="{ props: activatorProps }">
			<v-btn
				v-bind="activatorProps"
				density="compact"
				icon="mdi-plus"
				size="large"
				color="primary">
			</v-btn>
		</template>

		<template v-slot:default>
			<v-card class="">
				<v-container class="bg-grey-darken-4">
					<v-card
						elevation="0"
						class="d-flex flex-row align-center justify-space-between"
						color="transparent">
						<h2>Nova disciplina</h2>

						<v-btn
							elevation="0"
							density="compact"
							icon="mdi-close"
							size="large"
							color="grey-darken-4"
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
										label="Disciplina"
										variant="outlined"
										required></v-text-field>
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
	name: "VModalCreateSubject",
	data() {
		return {
			dialog: false,
			valid: false,
			subjectName: "",
		};
	},
	methods: {
		async save() {
			try {
				await axios.post("http://localhost:8080/subject", {
					subjectName: this.subjectName,
				});

				// Emitindo o evento com os dados da nova subject
				emitter.emit("getSubjects");

				this.resetForm();
				this.dialog = false;
			} catch (error) {
				console.error(error);
			}
		},
		resetForm() {
			this.$refs.form.reset();
			this.$refs.form.resetValidation();
		},
	},
};
</script>
