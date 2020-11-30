import Vue from 'vue'
import Router from 'vue-router'
import Login from './components/Login.vue'
import SignUp from './components/Signup.vue'
import Feed from './components/feed.vue'
import Post from './components/Post.vue'
import MyPage from './components/MyPage.vue'
import PwdChange from './components/PwdChange.vue'
import Explore from './components/Explore.vue'

// 이렇게 함으로써 현재 생성된 Vue 인스턴스에 Router가 연결 된 것!
// 그래서 App.vue에서는 <router-view/> 태그 호출만으로 url을 불러올 수 있음
Vue.use(Router);

export default new Router({
    mode: "history",
    routes: [
        { path: '/login', component: Login },
        { path: '/signup', component: SignUp },
        { path: '/feed', component: Feed },
        { path: '/post', component: Post },
        { path: '/explore', component: Explore },
        { path: '/mypage', component: MyPage },
        { path: '/pwdChange', component: PwdChange },
    ]
})