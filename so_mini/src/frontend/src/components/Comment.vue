<template>
  <div class="comments--size">
    <div v-for="comment in comments"
         v-bind="comment.userName"
         :comment="comment"
    >
      <b>{{comment.userName}}</b> {{comment.content}}
    </div>
  </div>
</template>

<script>
  export default {
    name: "Comment",
    props: {
      comments : Array,
    },
  }
</script>

<style scoped>
  .comments--size {

  }

</style>
