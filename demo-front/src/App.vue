<template>
  <v-app>
    <v-main>
      <v-container>
        <h1>Spring 응답:</h1>
        <p>{{ message }}</p>

        <v-btn color="primary" @click="fetchTest">/api/test 호출</v-btn>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      message: ''
    }
  },
  methods: {
    async fetchTest() {
      try {
        const res = await axios.get('/api/test')
        this.message = res.data // "안녕"
      } catch (err) {
        console.error(err)
        this.message = '에러 발생'
      }
    }
  }
}
</script>
