// src/main.js

import { createApp } from 'vue';
import App from './App.vue';

import vuetify from './plugins/vuetify'; // plugin 추가
import '@mdi/font/css/materialdesignicons.css';
import 'vuetify/styles';

createApp(App).use(vuetify).mount('#app');
