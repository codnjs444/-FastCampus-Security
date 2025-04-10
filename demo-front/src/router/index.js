import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import LoginView from '@/views/LoginView.vue'
import SignUpView from '@/views/SignUpView.vue'
import AdminView from '@/views/AdminView.vue'
import UserView from '@/views/UserView.vue'
import axios from 'axios' // ✅ 이 부분 추가해야 axios 사용 가능

const routes = [
  { path: '/', name: 'home', component: HomeView },
  { path: '/login', name: 'login', component: LoginView },
  { path: '/signup', name: 'signup', component: SignUpView },
  { path: '/admin', name: 'admin', component: AdminView },
  { path: '/user', name: 'user', component: UserView },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

// ✅ 전역 라우터 가드
router.beforeEach(async (to, from, next) => {
  if (to.name === 'admin') {
    try {
      // 관리자 API 호출로 로그인 여부 + 권한 체크
      await axios.get('/api/admin', { withCredentials: true });
      next(); // ✅ 통과
    } catch (err) {
      if (err.response?.status === 401) {
        // ⛔ 로그인 안 된 상태 → 로그인 페이지로, 원래 가려던 주소 포함
        next({ name: 'login', query: { redirect: to.fullPath } });
      } else {
        // ⛔ 로그인은 했지만 관리자 권한 없음
        alert('권한이 없습니다.');
        next({ name: 'home' });
      }
    }
  } else {
    next(); // 그 외 페이지는 모두 통과
  }
});

export default router;
