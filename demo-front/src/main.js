import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import vuetify from './plugins/vuetify'
import 'vuetify/styles'
import '@mdi/font/css/materialdesignicons.css'

import axios from 'axios'
axios.defaults.withCredentials = true // 세션 쿠키 포함

createApp(App).use(router).use(vuetify).mount('#app')
