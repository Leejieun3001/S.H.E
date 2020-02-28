import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
  mode : "history",
  routes : [
    {
      path: "/",
      alias: "/users/login",
      name: "users-login",
      component: () => import("./views/LoginPage")
    },
    {
      path: "/users/signup",
      name: "users-signup",
      component: () => import("./views/SignupPage")
    },
    {
      path: "/users/:id",
      name: "users-timeline",
      component: () => import("./views/TimelinePage")
    },

  ]
});
