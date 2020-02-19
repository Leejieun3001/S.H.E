<template>
  <div id="wrapper">
    <div class="header">
      <div class="header__profile">
        <div class="header__profile__image">
          <img class="header__profile__image--size"
               src="../assets/example1.jpg">
        </div>
      </div>
      <div class="header__title">
        <div><b>audeeke123</b></div>
        <div>Starbucks Sadang</div>
      </div>
      <div class="header__button">
        <i class="ellipsis vertical icon"></i>
      </div>
    </div>
    <div class="container">
      <div class="content">
        <div class="content__image">
          <img class="content__image--size"
               src="../assets/example1.jpg"/>
        </div>
      </div>
    </div>
    <div class="footer"></div>
  </div>
</template>

<script>
    export default {
        name: "blabla"
    }
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
  .content__image--size {
    width : 614px;
    height : 500px;
    text-align : left !important;
    margin-top : 10px;
  }
</style>
