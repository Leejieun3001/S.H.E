<template>
  <sui-comment-group threaded >
      <h5 is="sui-header" v-if="comments.length > 0">댓글 {{comments.length}}개 보기</h5>
      <sui-comment
        v-for="comment in comments"
        v-bind="comment.userName"
        :comment="comment"
      >
        <sui-comment-content>
          <a is="sui-comment-author">{{comment.userName}}</a>
          <sui-comment-metadata>
            <div>{{comment.registerDateTime}}</div>
          </sui-comment-metadata>
          <sui-comment-text>
            {{comment.content}}
          </sui-comment-text>
        </sui-comment-content>
      </sui-comment>
  </sui-comment-group>
</template>

<script>
  import CommentItem from '../models/comment/CommentItem'

  let comments_test = [
    new CommentItem('jihyun', '02.17 12:30', 'dfjkadkdkf'),
    new CommentItem('jieun', '02.17 12:40', 'dfjkaf;dajfkl'),
    new CommentItem('sol', '02.17 12:50', 'fdjkafjdaf'),
  ];

  export default {
    name: "Comment",
    props: {
      comments: {
        type : Array,
        required : true,
        description: "댓글 항목들"
      }
    },
    data() {
      return {
        test: comments_test
      }
    }
  }
</script>

<style scoped>

</style>
