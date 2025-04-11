<template>
  <!-- 인증된 관리자만 표시 -->
  <v-container v-if="authorized">
    <h2 class="text-h5 font-weight-bold">🔒 관리자 페이지</h2>
    <p>이곳은 관리자 전용입니다.</p>
  </v-container>
</template>

<script setup>
import { ref } from 'vue';

// 👇 authorized 상태는 외부에서 전달되거나 기본값 true로 설정 가능
const authorized = ref(true); // 어차피 라우터 가드에서 걸러짐
</script>
