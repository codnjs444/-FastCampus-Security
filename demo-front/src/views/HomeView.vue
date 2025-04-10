<template>
  <v-container>
    <h2>홈 페이지 (테스트용)</h2>
    <v-btn color="primary" @click="loadTest">/api/test 호출</v-btn>
    <p>{{ message }}</p>
    <v-btn @click="go('/user')">User 페이지</v-btn>
    <v-btn @click="go('/main')">Main 페이지</v-btn>
    <v-btn @click="go('/admin')">Admin 페이지</v-btn>
  </v-container>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'

const message = ref('')
const router = useRouter()

const loadTest = async () => {
  const res = await axios.get('/api/test')
  message.value = res.data
}

const go = (path) => router.push(path)
</script>