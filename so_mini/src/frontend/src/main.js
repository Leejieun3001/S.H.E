import Vue from 'vue'
import SuiVue from 'semantic-ui-vue';
import App from './App.vue'

export const eventBus = new Vue()

Vue.use(SuiVue);

new Vue({
  el: '#app',
  render: h => h(App)
})
