import Vue from 'vue'
import SuiVue from 'semantic-ui-vue';
import App from './App.vue'
import router from './router'
import axios from 'axios';
import VueAxios from 'vue-axios';
import 'jquery';

Vue.use(SuiVue);
Vue.use(VueAxios, axios);

Vue.prototype.$axios = axios;
Vue.config.productionTip = false;

new Vue({
  render: h => h(App),
  router
}).$mount('#app')
