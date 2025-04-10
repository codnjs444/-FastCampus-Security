<template>
  <v-container>
    <h2>로그인</h2>
    <v-form @submit.prevent="login">
      <v-text-field v-model="username" label="아이디" />
      <v-text-field v-model="password" label="비밀번호" type="password" />
      <v-btn type="submit" color="primary">로그인</v-btn>
    </v-form>
    <p v-if="error" style="color:red">{{ error }}</p>
  </v-container>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import axios from 'axios'

const username = ref('')
const password = ref('')
const error = ref('')
const router = useRouter()

const login = async () => {
  try {
    await axios.post('/loginProc', new URLSearchParams({
      username: username.value,
      password: password.value
    }), {
      headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    })
    router.push('/')
  } catch {
    error.value = '로그인 실패'
  }
}
</script>