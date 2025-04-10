// LoginView.vue
<template>
  <v-container class="fill-height" fluid>
    <v-row justify="center" align="center">
      <v-col cols="12" sm="8" md="4">
        <v-card>
          <v-card-title>로그인</v-card-title>
          <v-card-text>
            <v-text-field v-model="form.username" label="아이디" required />
            <v-text-field v-model="form.password" label="비밀번호" type="password" required />
            <v-btn color="primary" block @click="submit">로그인</v-btn>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter, useRoute } from 'vue-router'; // ✅ useRoute 추가
import axios from 'axios';

const router = useRouter();
const route = useRoute(); // ✅ 현재 라우터 정보 사용

const form = ref({
  username: '',
  password: ''
});

const submit = async () => {
  try {
    const params = new URLSearchParams();
    params.append('username', form.value.username);
    params.append('password', form.value.password);

    await axios.post('/api/login', params, {
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      withCredentials: true
    });

    alert('로그인 성공');

    const redirectPath = route.query.redirect || '/'; // ✅ 정의된 route 사용
    router.push(redirectPath);
  } catch (err) {
    alert('로그인 실패: 아이디 또는 비밀번호를 확인하세요.');
  }
};
</script>
