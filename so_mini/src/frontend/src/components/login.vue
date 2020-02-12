<template>
  <div class="container">
  <div>
    <h3>SO_MINI</h3>
    <sui-input placeholder="사용자이름 또는 이메일" />
    <sui-input placeholder="비밀번호" />
    <sui-button loading primary content="로그인" />
  </div>
  <div></div>
  </div>
</template>

<script>
    export default {
        name: "login"
    }
</script>

<style scoped>
.container {
  text-align : center;
}
</style>
