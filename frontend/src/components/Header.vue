<script setup lang="ts">
import { RouterLink } from 'vue-router'
</script>

<template>
  <header>
    <div class="header-container">
      <div class="logo-wrapper">
        <RouterLink class="logo" :to="{ name: 'home' }">
          <span class="logo-text">Member<span class="accent">Management</span></span>
        </RouterLink>
      </div>
      <nav class="nav-menu">
        <ul class="menu-items">
          <li class="menu-item">
            <RouterLink :to="{ name: 'home' }" class="nav-link">ホーム</RouterLink>
          </li>
          <li class="menu-item">
            <RouterLink :to="{ name: 'login' }" class="nav-link login-btn">ログイン</RouterLink>
          </li>
        </ul>
      </nav>
    </div>
  </header>
</template>

<style scoped>
* {
  font-family: 'Segoe UI', Roboto, 'Helvetica Neue', sans-serif;
  box-sizing: border-box;
}

header {
  position: sticky;
  top: 0;
  width: 100%;
  z-index: 100;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.08);
}

.header-container {
  background-color: #ffffff;
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 70px;
  padding: 0 2rem;
  max-width: 1400px;
  margin: 0 auto;
}

.logo-wrapper {
  display: flex;
  align-items: center;
}

.logo {
  text-decoration: none;
  display: flex;
  align-items: center;
}

.logo-text {
  font-weight: 700;
  font-size: 1.4rem;
  color: #333;
  letter-spacing: -0.5px;
}

.accent {
  background: linear-gradient(90deg, #4a90e2, #63b3ed);
  -webkit-background-clip: text;
  background-clip: text;
  color: transparent;
  margin-left: 2px;
}

.nav-menu {
  display: flex;
  align-items: center;
}

.menu-items {
  list-style: none;
  display: flex;
  align-items: center;
  gap: 2rem;
  padding: 0;
  margin: 0;
}

.menu-item {
  padding: 0;
}

.nav-link {
  text-decoration: none;
  color: #4a5568;
  font-weight: 500;
  font-size: 0.95rem;
  padding: 0.5rem 0;
  position: relative;
  transition: color 0.2s ease;
}

.nav-link:hover {
  color: #4a90e2;
}

.nav-link:hover::after {
  content: '';
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 2px;
  background: linear-gradient(90deg, #4a90e2, #63b3ed);
  transform: scaleX(1);
  transform-origin: left;
  transition: transform 0.3s ease;
}

.login-btn {
  background-color: #4a90e2;
  color: white;
  padding: 0.5rem 1.2rem;
  border-radius: 5px;
  font-weight: 500;
  transition:
    background-color 0.3s ease,
    transform 0.1s ease;
}

.login-btn:hover {
  background-color: #3a7bc8;
  color: white;
}

.login-btn:hover::after {
  display: none;
}

@media (max-width: 768px) {
  .header-container {
    padding: 0 1rem;
  }

  .menu-items {
    gap: 1rem;
  }

  .logo-text {
    font-size: 1.2rem;
  }
}
</style>
