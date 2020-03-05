import Vue from 'vue'
import Router from 'vue-router'
import Login from './components/Login.vue'
import SignUp from './components/Signup.vue'
import Feed from './components/feed.vue'
import Post from './components/Post.vue'
import MyPage from './components/MyPage.vue'
import PwdChange from './components/PwdChange.vue'

Vue.use(Router); //플러그인 등록

export default new Router({
    mode: "history",
    routes: [
        { path: '/login', component: Login },
        { path: '/signup', component: SignUp },
        { path: '/feed', component: Feed },
        { path: '/post', component: Post },
        { path: '/mypage', component: MyPage },
        { path: '/pwdChange', component: PwdChange },
    ]
})