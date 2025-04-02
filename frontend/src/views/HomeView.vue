<script setup lang="ts">
import { onMounted, ref } from 'vue'
import axios from 'axios'

const message = ref(null)

onMounted(async () => {
  await getMessage()
})

async function getMessage() {
  const response = await axios.get('http://localhost:8080/api/v1/hello')
  message.value = response.data
}
</script>

<template>
  <div>
    <h1>{{ message }}</h1>
  </div>
</template>
