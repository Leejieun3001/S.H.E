<template>
  <div id="app">
    <HeaderContent></HeaderContent>
    <MyPage
    :userInfo="userInfo"/>
  </div>
</template>

<script>
  import headers from "./components/HeaderContent";
  import mypage from "./components/MyPage";
  import userInfo from "./data/userInfo";
  
  export default {
    name: 'app',
    components :  { 
      "HeaderContent" : headers,
      "MyPage" : mypage
    },
    data() {
      return {
        userInfo,
      }
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
