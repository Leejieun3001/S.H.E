<template>
  <div class="container">
    <h1 id="name">SO._.MINI</h1>
    <div class="sns-login main-color" style="margin-top : 1rem;">
      <div class="sns-login-detail">
        <sui-button class="login" color="yellow">
          <img class="kakao-login" src="../assets/kakao_logo.png" align="center"/>
          <b>kakao로 로그인</b>
        </sui-button>
      </div>
    </div>
    <div class="sns-login main-color">
      <div class="sns-login-detail">
        <sui-button  class="login" color="green">
          <img class="google-login" src="../assets/google_logo.png" align="top"/>
          <b>google로 로그인</b>
        </sui-button>
      </div>
    </div>
    <div class="position-changed">
      <sui-input class="form-type"
                 type="text"
                 placeholder="이메일 주소"
                 v-model="userEmail"/>
    </div>
    <div></div>
    <div class="position-changed">
      <sui-input class="form-type"
                 type="text"
                 placeholder="성명"
                 v-model="userName"/>
    </div>
    <div></div>
    <div class="position-changed">
      <sui-input class="form-type"
                 type="text"
                 placeholder="사용자 이름"
                 v-model="userId"/>
    </div>
    <div></div>
    <div class="position-changed">
      <sui-input class="form-type"
                 type="password"
                 placeholder="비밀번호"
                 v-model="password"/>
    </div>
    <div>
      <sui-button class="login"
                  :class="{primary : isAbledLogin}">가입</sui-button>
    </div>
    <div class="main-color" style="padding-top:1rem;">
      계정이 있으신가요? <a href="#"><span style="color: #3897f0;"><b>로그인</b></span></a>
    </div>
  </div>
</template>

<script>
  export default {
    name: "login",
    data() {
      return {
        userId :'',
        password: ''
      }
    },
    computed: {
      isAbledLogin() {
        if (this.userId.length >= 0 || this.password.length >= 0)
          return true;
      }
    }
  }
</script>

<style scoped>
  #name {
    padding-top: 2rem;
    padding-bottom: 1rem;
  }

  .container {
    width: 100%;
    height: 100%;
    margin: 10px 10px 10px 10px;
    text-align: center;
    /*border: 1px solid #e6e6e6;*/
  }

  .position-changed {
    display: inline-block;
  }

  .form-type {
    width: 300px;
    margin-top: 0.5rem;
  }

  .login {
    width: 300px;
    margin-top: 1rem;
  }

  .sns-login {
    text-align : center;
  }

  .sns-login-detail {
    display : inline-block;
  }

  .main-color {
    color : #385185;
  }

  .kakao-login {
    align : center;
    width: 20px;
    height: 22px;
    /*margin-top: 1rem;*/
    /*margin-bottom: 1rem;*/
    /*padding-top : 1px;*/
  }

  .google-login {
    align : center;
    width: 18px;
    height: 20px;
    /*margin-bottom: 1rem;*/
    /*margin-bottom: 1rem;*/
  }

  .line {
    width : 100%;
    margin : 0;
    padding : 0;
    text-align : center;
    font-size : 12px;
  }
  .line:after {
    display : inline-block;
    margin :0 0 3px 20px;
    height : 1px;
    content: "";
    text-shadow : none;
    background-color : #999;
    width : 40%;
  }
  .line:before{
    display : inline-block;
    margin : 0 20px 3px 0;
    height:1px;
    content : "";
    text-shadow : none;

  }

</style>
