<script setup>
import VCourses from '@/components/VCourses.vue'
</script>

<template>
  <div class="container">
    <h1>Cursos</h1>
    <div class="item">
      <div class="dash-grid">
        <VCourses />
      </div>
    </div>
  </div>
</template>

<style scoped>
.container {
  padding: 10px;
  box-sizing: border-box;
  width: calc(100% - 255px);
  height: 100vh;
  background-color: #e0e0e0;
}

h1 {
  color: black;
  font-size: 2rem;
  font-weight: bold;
}

.items {
  display: flex;
  flex-direction: column;
  gap: 5px;
  height: 100%;
  /* border: solid 1px red; */
}
</style>
