<template>
  <div class="wrapper">
<!--    <div class="header">-->
<!--      <HeaderContent></HeaderContent>-->
<!--    </div>-->
    <div class="container">
      <post v-for="post in posts"
            :post="post"
            :key="posts.indexOf(post)">
      </post>
    </div>
  </div>
</template>

<script>
  import Post from "../components/Post"
  import HeaderContent from "../components/HeaderContent"

  export default {
    name: "TimelinePage",
    props: {
      posts : Array
    },
    components : {
      "Post" : Post,
      "HeaderContent" : HeaderContent,
    },

  }
</script>

<style scoped>

</style>
