<template>
  <!-- 인증된 관리자만 표시 -->
  <v-container v-if="authorized">
    <h2 class="text-h5 font-weight-bold">🔒 관리자 페이지</h2>
    <p>이곳은 관리자 전용입니다.</p>
  </v-container>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import axios from 'axios';

const authorized = ref(false);
const router = useRouter();

onMounted(async () => {
  try {
    await axios.get('/api/admin', { withCredentials: true });
    authorized.value = true;
  } catch (e) {
    if (e.response?.status === 401) {
      router.push({ name: 'login', query: { redirect: '/admin' } });
    } else {
      alert('권한이 없습니다.');
      router.push({ name: 'home' });
    }
  }
});
</script>
