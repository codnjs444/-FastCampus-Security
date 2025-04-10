import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import LoginView from '@/views/LoginView.vue'
import SignUpView from '@/views/SignUpView.vue'
import AdminView from '@/views/AdminView.vue'
import UserView from '@/views/UserView.vue'

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

export default router
