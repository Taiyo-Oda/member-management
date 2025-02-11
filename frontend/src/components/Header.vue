<script setup lang="ts">
import { RouterLink } from 'vue-router'
</script>

<template>
  <header>
    <div class="header-container">
      <div class="title-wrapper">
        <RouterLink class="router-link" :to="{ name: 'home' }">Member Management</RouterLink>
      </div>
      <nav>
        <div class="header-menu-wapper">
          <RouterLink class="router-link" :to="{ name: 'login' }">Login</RouterLink>
        </div>
      </nav>
    </div>
  </header>
</template>

<style scoped>
template * {
  font-family: sans-serif;
}

.header-container {
  background-color: #f9f4f0;
  color: #000;
  padding: 5px 10px;
  display: flex;
  justify-content: space-between;
}

.router-link {
  text-decoration: none;
  color: #000;
}
</style>
