<template>
  <div class="table-cursos">
    <v-table fixed-header="true" :height="tableHeight">
      <thead class="thead-table">
        <tr>
          <th class="text-left">Dia da semana</th>
          <th class="text-left">Disciplina</th>
          <th class="text-left">Horários</th>
          <th class="text-left">Professor</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(schedule, index) in this.schedules" :key="index">
          <td>{{ schedule.dayOfWeek }}</td>
          <td>{{ schedule.schedules[0].discipline }}</td>
          <td>{{ schedule.schedules[0].time }}</td>
          <td>{{ schedule.schedules[0].teacher }}</td>
        </tr>
      </tbody>
    </v-table>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'VSchedules',
  components: {},
  data() {
    return {
      schedules: []
    }
  },
  props: {
    tableHeight: {
      type: Number,
      default: 500
    }
  },
  mounted() {
    this.getSchedules()
  },
  methods: {
    getSchedules() {
      axios
        .get('http://localhost:3000/schedule')
        .then((res) => {
          this.schedules = res.data

          console.log('👉 this.schedules => ', this.schedules)
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
