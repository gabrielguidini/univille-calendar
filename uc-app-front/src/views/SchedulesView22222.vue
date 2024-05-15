<template>
  <main></main>
  <div class="container">
    <h1>Horários</h1>
    <div class="item">
      <div class="dash-grid">
        <VSchedules :tableHeight="400" />
      </div>
    </div>
  </div>
</template>

<script>
import VSchedules from '../components/VSchedules.vue'

export default {
  components: {
    VSchedules
  }
}
</script>

<style>
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
