<template>
  <h1>teacher</h1>
  <p>{{ this.teachers }}</p>
</template>

<script>
import axios from 'axios'

export default {
  name: 'VTeachers',
  data() {
    return {
      teachers: []
    }
  },
  mounted() {
    this.getTeachers()
  },
  methods: {
    getTeachers() {
      axios
        .get('http://localhost:8080/allTeachers')
        .then((res) => {
          this.teachers = res.data
          console.log('👉 this.teachers => ', this.teachers)
          console.log('👉 Eu consegui')
        })
        .catch((error) => {
          console.log(error)
          console.log('👉 Eu tenteeeei')
        })
    }
  }
}
</script>

<style scoped></style>
