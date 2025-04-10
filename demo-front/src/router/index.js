import { createRouter, createWebHistory } from 'vue-router'

import HomeView from '@/views/HomeView.vue'
import LoginView from '@/views/LoginView.vue'
import UserView from '@/views/UserView.vue'
import MainView from '@/views/MainView.vue'
import AdminView from '@/views/AdminView.vue'

const routes = [
  { path: '/', component: HomeView },
  { path: '/login', component: LoginView },
  { path: '/user', component: UserView },
  { path: '/main', component: MainView },
  { path: '/admin', component: AdminView },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
