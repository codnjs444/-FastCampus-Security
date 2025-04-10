<template>
  <v-container>
    <h2>USER/MAIN/ADMIN 페이지</h2>
    <v-btn @click="loadData">API 호출</v-btn>
    <p>{{ result }}</p>
  </v-container>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return { result: '' }
  },
  methods: {
    async loadData() {
      try {
        const path = this.$route.path
        const res = await axios.get('/api' + path)
        this.result = res.data
      } catch (e) {
        if (e.response.status === 401 || e.response.status === 403) {
          this.$router.push('/login')
        } else {
          this.result = '오류 발생'
        }
      }
    }
  }
}
</script>
