<template>
  <div id="app">
<<<<<<< HEAD
    <LoginPage></LoginPage>
<!--    <SignupPage></SignupPage>-->
<!--    <TimelinePage-->
<!--      :posts="posts"/>-->
=======
    <HeaderContent></HeaderContent>
    <MyPage
    :userInfo="userInfo"/>
>>>>>>> upstream/master
  </div>
</template>

<script>
<<<<<<< HEAD
  // import posts from "./data/posts";
  // import TimelinePage from "./views/TimelinePage"
  import LoginPage from "./views/LoginPage"
  // import SignupPage from "./views/SignupPage"

=======
  import headers from "./components/HeaderContent";
  import mypage from "./components/MyPage";
  import userInfo from "./data/userInfo";
  
>>>>>>> upstream/master
  export default {
    name: 'app',
    components :  { 
      "HeaderContent" : headers,
      "MyPage" : mypage
    },
    data() {
      return {
<<<<<<< HEAD
        // posts,
      }
    },
    components : {
      // "TimelinePage" : TimelinePage,
      "LoginPage" : LoginPage,
      // "SignupPage" : SignupPage,
=======
        userInfo,
      }
>>>>>>> upstream/master
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
