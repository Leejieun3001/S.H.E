<template>
  <div id="wrapper">
    <div class="header">
      <div class="header__profile">
        <div class="header__profile__image">
          <img class="header__profile__image--size"
               :src="post.userImage">
        </div>
      </div>
      <div class="header__title">
        <div><b>{{post.userName}}</b></div>
        <div>{{post.location}}</div>
      </div>
      <div class="header__button">
        <i @click="isClicked"
          class="ellipsis vertical icon">
        </i>
      </div>
    </div>
    <div class="container">
      <div class="content">
        <div class="content__image">
          <img class="content__image--size"
               :src="post.postImage"/>
        </div>
        <div class="content__likes">
          <i class="heart icon large"
             :class="{'red' : this.post.hasBeenLiked}"
             @click="like">
          </i> &nbsp
          <i class="comment outline icon large"
             v-html="index">
          </i>
          <p class="likes">{{post.likes}}명이 좋아합니다.</p>
          <p class="caption">
            <span><b>{{post.userName}}</b></span>
            {{post.caption}}
          </p>
        </div>
        <div class="content__comments">
          <div v-if="post.comments.length>0"
               style="color:#999">
            <b>댓글{{post.comments.length}}개보기</b>
          </div>
          <div v-if="post.comments.length>0">
            <comment
              :comments="post.comments">
            </comment>
          </div>
        </div>
      </div>
    </div>
    <div class="footer">
      <div class="footer__input">
        <sui-form>
          <sui-form-field>
            <textarea
              placeholder="댓글 달기.."
              rows="1"
              type="text"
              v-model="newComment"
              v-on:keyup.enter="addComment"
            >
            </textarea>
          </sui-form-field>
        </sui-form>
      </div>
      <div class="footer__submit">
        <sui-button type="submit"
                    color="blue"
                    v-on:click="addComment">게시
        </sui-button>
      </div>
    </div>
  </div>
</template>

<script>
  import Comment from "./Comment";

  export default {
    name: "Post",
    data() {
      return {
        newComment:''
      }
    },
    props: {
      post : Object
    },
    components : {
      "Comment" : Comment,
    },
    methods: {
      like() {
        this.post.hasBeenLiked ? this.post.likes-- : this.post.likes++;
        this.post.hasBeenLiked = !this.post.hasBeenLiked;
      },
      isClicked() {
        alert("팔로우를 정말 취소하시겠습니까?");
      },
      addComment() {
        if(this.newComment !== "") {
          let value = this.newComment && this.newComment.trim();
          // 댓글을 갱신하는 작업 필요
          this.clearInput();
        }
      },
      clearInput() {
        this.newComment='';
      }
    }
  };
</script>

<style scoped>
  #wrapper {
    width : 50%;
    margin : 0 auto;
    /*position : relative;*/
    /*background : #000;*/

  }

  .header {
    display : flex;
    flex-direction : row;
    align-items : center;
    justify-content : space-between;
  }
  .header__profile {
    flex : 1 1 auto;
  }
  .header__profile__image {
    width : 32px;
    height : 32px;
    border-radius : 70%;
    overflow : hidden;
  }
  .header__profile__image--size {
    width : 100%;
    height : 100%;
    object-fit : cover; /*이미지와 같은 오브젝트를 받아서 비율을 그대로 유지한 채로 이미지를 가공할 수 있음*/
  }
  .header__title {
    flex : 15 15 auto;
    text-align : left;
  }
  .header__button {
    flex : 1 1 auto;
  }
  .content {
    text-align : left !important;
  }
  .content__image--size {
    width : 620px;
    height : 500px;
    margin-top : 10px;
    margin-bottom: 10px;
  }

  .content__likes {
    padding-left : 1rem;
    padding-bottom : 1rem;
  }
  .content__comments {
    padding-left : 1rem;
    padding-bottom : 1rem;
  }

  .likes {
    margin: 5px 0;
    margin-bottom: 5px !important;
    /*font-size: 0.85rem;*/
    font-weight: bold;
  }
  .footer {
    display : flex;
    flex-direction : row;
    padding-left : 1rem;
    padding-right : 1rem;
    margin-bottom : 4rem;
  }
  .footer__input {
    flex : 8 8 auto;
  }
  .footer__submit {
    flex : 1 1 auto;
  }
  .caption {
    /*font-size: 0.85rem;*/
  }
</style>
