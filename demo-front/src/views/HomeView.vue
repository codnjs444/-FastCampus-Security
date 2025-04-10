<template>
  <v-app>
    <!-- ✅ 2025-04-10: 홈 화면 전체 및 헤더 구성 -->
    <v-app-bar app flat color="white" elevation="1">
      <v-toolbar-title class="font-weight-bold text-h6">MyPlatform</v-toolbar-title>

      <v-spacer />

      <v-btn variant="text" @click="goTo('admin')">관리자 페이지</v-btn>
      <v-btn variant="text" @click="goTo('user')">유저 페이지</v-btn>

      <v-spacer />

      <v-btn color="primary" variant="outlined" class="me-2" @click="goTo('login')">
        로그인
      </v-btn>
      <v-btn color="primary" variant="flat" @click="goTo('signup')">
        회원가입
      </v-btn>
    </v-app-bar>

    <v-main class="d-flex align-center justify-center" style="min-height: 80vh">
      <div class="text-center">
        <h1 class="text-h3 font-weight-bold mb-4">환영합니다 👋</h1>
        <p class="text-subtitle-1">우리 플랫폼에 오신 걸 환영합니다. 원하는 메뉴를 선택해주세요.</p>
      </div>
    </v-main>
  </v-app>
</template>

<script setup>
import { useRouter } from 'vue-router';

const router = useRouter();
const goTo = (page) => {
  router.push({ name: page });
};
</script>

<style scoped>
.v-btn {
  text-transform: none;
  font-weight: 500;
}
</style>