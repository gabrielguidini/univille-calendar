<script setup>
import VSidebar from "./components/VSidebar.vue";
</script>

<template>
  <main class="container">
    <div class="div-side">
      <VSidebar />
    </div>
    <div class="div">
      <router-view />
    </div>
  </main>
</template>

<style>
.container {
  display: flex;
  flex-direction: row;
}
</style>
