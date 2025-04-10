<template>
  <v-container class="fill-height" fluid>
    <v-row justify="center" align="center">
      <v-col cols="12" sm="8" md="4">
        <v-card>
          <v-card-title>회원가입</v-card-title>
          <v-card-text>
            <v-text-field v-model="form.username" label="아이디" required />
            <v-text-field v-model="form.password" label="비밀번호" type="password" required />
            <v-btn color="primary" block @click="submit">회원가입</v-btn>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';
const router = useRouter();


const form = ref({
  username: '',
  password: ''
});

const submit = async () => {
  try {
    const res = await axios.post('/api/join', form.value);
    alert(res.data);
    router.push({ name: 'home' });

  } catch (err) {
    alert(err.response?.data?.message || '회원가입 중 오류 발생');
  }
};
</script>