import Vue from 'vue'
import SuiVue from 'semantic-ui-vue';
import App from './App.vue'
import VueRouter from 'vue-router';

export const eventBus = new Vue()

Vue.use(SuiVue);
Vue.use(VueRouter);

const routes = [
  // router 등록
];

const router = new VueRouter({
  routes
})
new Vue({
  el: '#app',
  render: h => h(App),
  router // router 추가
})
