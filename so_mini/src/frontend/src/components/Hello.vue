<template>
  <div class="content">
    <h2 class="padding-40p">로그인</h2>
    <form class="ui form">
      <div class="field">
        <label>아이디</label>
        <input v-model="userId" type="text" placeholder="아이디">
      </div>
      <div class="field">
        <label>비밀번호</label>
        <input v-model="password" type="password" placeholder="비밀번호">
      </div>
      <div class="field">
        <button type="submit" class="ui primary button" :class="{disabled: isDisabledLogin}">
          로그인
        </button>
      </div>
    </form>
    <br/>
    <div class="ui sign-up">
      아직 계정이 없으신가요? <a href="#">계정만들기</a>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        userId: '',
        password: ''
      }
    },
    computed: {
      isDisabledLogin() {
        if (this.userId.length <= 0 || this.password.length <= 0)
          return true;
      }
    }
  }
</script>

<style scoped>
  .content {
    margin: 0 35%;
  }

  .button {
    width: 100%
  }

  .padding-40p {
    padding: 0 40%;
  }

  a {
    text-decoration: none;
    transition: .06s;
    transition-duration: 0.06s;
    transition-property: all;
    transition-timing-function: ease-in-out;
    transition-delay: initial;
  }

  .sign-up {
    font-size: 13px;
    text-align: center;
    color: #98A8B9;
  }

  .sign-up a {
    padding-left: 0.25rem;
    font-weight: 500;
    color: #263747;
    text-decoration: none;
  }

  .sign-up a:hover {
    color: #0078FF;
  }

  .sign-up a:after {
    transition-duration: 0.06s;
    transition-property: all;
    transition-timing-function: ease-in-out;
    transition-delay: initial;
    display: inline-block;
    vertical-align: top;
    margin-left: 0.25rem;
    content: ' > ';
  }

  .sign-up a:hover:after {
    transform: translateX(0.25rem);
  }

</style>
