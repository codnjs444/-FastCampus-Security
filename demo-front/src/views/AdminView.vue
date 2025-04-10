<template>
  <v-container>
    <h2>페이지</h2>
    <v-btn @click="loadData">API 호출</v-btn>
    <p>{{ result }}</p>
  </v-container>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import axios from 'axios'

const result = ref('')
const route = useRoute()
const router = useRouter()

const loadData = async () => {
  try {
    const res = await axios.get('/api' + route.path)
    result.value = res.data
  } catch (e) {
    if (e.response?.status === 401 || e.response?.status === 403) {
      router.push('/login')
    } else {
      result.value = '오류 발생'
    }
  }
}

onMounted(() => {
  loadData()
})
</script>