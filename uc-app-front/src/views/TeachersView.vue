<script setup>
import VTeachers from "../components/VTeachers.vue";
</script>

<template>
  <main class="container">
    <div class="card-teachers">
      <VTeachers />
    </div>
  </main>
</template>

<style>
.container {
  margin-left: 207px;
}

.card-teachers {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 10px;
  background-color: blue;
  border: 1px solid red;
}
</style>
