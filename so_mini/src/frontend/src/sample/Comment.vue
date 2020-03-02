<template>
<!--  <sui-comment-group threaded >-->
<!--    <h5 is="sui-header" v-if="comments.length > 0"  dividing   >댓글 {{comments.length}}개 보기</h5>-->
<!--    <div class="float-left">-->
<!--      <sui-comment-->
<!--        v-for="comment in comments"-->
<!--        v-bind="comment.userName"-->
<!--        :comment="comment"-->
<!--      >-->
<!--        <sui-comment-avatar src="../assets/logo.png" />-->
<!--        <sui-comment-content >-->
<!--          <a is="sui-comment-author">{{comment.userName}}</a>-->
<!--          <sui-comment-metadata>-->
<!--            <div>{{comment.registerDateTime}}</div>-->
<!--          </sui-comment-metadata>-->
<!--          <sui-comment-text>-->
<!--            {{comment.content}}-->
<!--          </sui-comment-text>-->
<!--          <sui-comment-actions>-->
<!--            <sui-comment-action>Reply</sui-comment-action>-->
<!--          </sui-comment-actions>-->
<!--        </sui-comment-content>-->
<!--      </sui-comment>-->
<!--    </div>-->
<!--  </sui-comment-group>-->
  <div>
    <div v-if="comments.length > 0">
      댓글 {{comments.length}}개 보기
    </div>
    <div v-for="comment in comments"
         v-bind="comment.userName"
         :comment="comment"
         class="left-aligned-container"
    >
      <b>{{comment.userName}}</b> {{comment.content}}
    </div>
  </div>
</template>

<script>
  import CommentItem from '../models/comment/CommentItem'

  let comments = [
    new CommentItem('jihyun', '02.17 12:30', '피곤하다'),
    new CommentItem('jieun', '02.17 12:40', '내일 어떻게 일어나지'),
    new CommentItem('sol_123', '02.17 12:50', '이힝힝유ㅜㅠㅜㅠㅜ'),
  ];

  export default {
    name: "Comment",
    data() {
      return {
        comments : comments
      }
    }
  }
</script>

<style scoped>
  .left-aligned-container {
    padding-left : 1rem;
  }
</style>
