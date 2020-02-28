<template>
  <div id="app">
    <LoginPage></LoginPage>
<!--    <SignupPage></SignupPage>-->
<!--    <TimelinePage-->
<!--      :posts="posts"/>-->
  </div>
</template>

<script>
  // import posts from "./data/posts";
  // import TimelinePage from "./views/TimelinePage"
  import LoginPage from "./views/LoginPage"
  // import SignupPage from "./views/SignupPage"

  export default {
    name: 'app',
    data () {
      return {
        // posts,
      }
    },
    components : {
      // "TimelinePage" : TimelinePage,
      "LoginPage" : LoginPage,
      // "SignupPage" : SignupPage,
    }
  }
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
