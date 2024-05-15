<template>
  <div class="table-cursos">
    <v-table fixed-header="true" height="600px">
      <thead class="thead-table">
        <tr>
          <th class="text-left">Discplina</th>
          <th class="text-left">Hora Aula</th>
          <!-- <th class="button-container text-left"></th> -->
        </tr>
      </thead>
      <tbody>
        <tr v-for="(discipline, index) in this.disciplines" :key="index">
          <td>{{ discipline.name }}</td>
          <td>{{ discipline.lesson_time }}</td>
          <!-- <td class="button-container text-left">
                <v-btn color="light-blue-darken-1">Visualizar</v-btn>
              </td> -->
        </tr>
      </tbody>
    </v-table>
  </div>
</template>

<script>
import VModal from './modal/VModal.vue'
import axios from 'axios'

export default {
  name: 'VSubjects',
  components: {
    VModal
  },
  data() {
    return {
      disciplines: []
    }
  },
  mounted() {
    this.getDisciplines()
  },
  methods: {
    getDisciplines() {
      axios
        .get('http://localhost:3000/disciplines')
        .then((res) => {
          this.disciplines = res.data
          // this.disciplines = res.data.disciplines
          console.log('👉 this.disciplines => ', this.disciplines)
        })
        .catch((error) => {
          console.log(error)
        })
    }
  }
}
</script>

<style scoped>
.container {
  width: 100vw;
  height: 100vh;
  padding: 20px;
  background-color: #e0e0e0;
}

.header {
  padding: 5px 20px;
  color: #212121;
  background-color: #fafafa;
  border-radius: 5px;
}

.items-table {
  display: flex;
  flex-direction: column;
  gap: 5px;
  height: 100%;
  margin-left: 255px;
  /* border: solid 1px red; */
}

.button-container {
  display: flex;
  justify-content: flex-end;
  flex-direction: row;
  align-items: center;
}

.table-cursos {
  overflow: hidden;
  box-sizing: border-box;
  /* border: solid 1px green; */
}
</style>
