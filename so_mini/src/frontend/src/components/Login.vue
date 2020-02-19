<template>
  <div class="container">
    <h1 id="name">SO._.MINI</h1>
    <div class="position-changed">
      <sui-input class="form-type" placeholder="사용자이름 또는 이메일"/>
    </div>
    <div></div>
    <div class="position-changed">
      <sui-input class="form-type" placeholder="비밀번호"/>
    </div>
    <div>
      <sui-button class="login" primary>로그인</sui-button>
    </div>
    <div class="position-changed">
      <hr> 또는 <hr>
    </div>
    <div class="sns-login main-color" style="margin-top : 1rem;">
      <div class="sns-login-detail">
        <img class="kakao-login" src="../assets/kakao_logo.png" align="center"/>
        <b>kakao로 로그인</b>
      </div>
    </div>
    <div class="sns-login main-color">
      <div class="sns-login-detail">
        <img class="google-login" src="../assets/google_logo.png" align="top"/>
        <b>google로 로그인</b>
      </div>
    </div>
    <div class="main-color" style="margin-top : 1rem;" >
      비밀번호를 잊으셨나요?
    </div>
    <div class="main-color">
      계정이 없으신가요? <span>가입하기</span>
    </div>
  </div>
</template>

<script>
  export default {
    name: "login"
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
    margin-top: 1rem;
    margin-bottom: 1rem;
  }

  .google-login {
    align : center;
    width: 18px;
    height: 20px;
    margin-bottom: 1rem;
    margin-bottom: 1rem;
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
