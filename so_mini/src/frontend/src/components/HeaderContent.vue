<template>
  <div class="box">
      <div class="container">
          <div class="content1">
              <a class href="./">
                <div class = "title-image">
                    <img src="src\assets\logo.png" alt="so._.mini logo" width="30px" height="30px"/>
                    <div class="column"></div>
                    <div class="logo">
                        <h3>so._.mini</h3>
                    </div>
                </div>
              </a>
          </div>
          <div class="content2">
            <form action="#">
                <input type="search" placeholder="Write text here...">
                <a href="#"><img class="btn" src="src\assets\search.png" alt="search_btn" width="20px" height="20px"/>></a>
            </form>
          </div>
          <div class="content3">
              <div class="icons">
                  <div class="explore-link">
                    <a href="./mypage">\
                        <img src="src\assets\explore.png" alt="explore-icon" width="25px" height="25px"/>
                    </a>
                  </div>
                  <div class="like-link">
                    <a href="./">\
                        <img src="src\assets\like.png" alt="like-icon" width="25px" height="25px"/>
                    </a>
                  </div>
                  <div class="profile-link">
                    <a href="./feed">\
                        <img src="src\assets\profile.png" alt="profile-icon" width="25px" height="25px"/>
                    </a>
                  </div>
              </div>
          </div>
      </div>
  </div>
</template>

<script>
    export default {
        name: "headerContent",
    };
</script>

<style scoped>
    .box {
        width: 100%;
        height: 77px;
        text-align: center;
        position: fixed; 
        border-bottom: 1px solid #b8b8b860;
        top: 0;
        background-color: #ffffff;
        transition: top 0.2s ease-in-out;
        align-items: center;
        flex-direction: column;
        z-index: 3;
        box-sizing: border-box;
        display: flex;
    }

    .container {
        align-items: center;
        text-align: center;
        display: flex;
        flex-direction: row;
        height: 77px;
        justify-content: center;
        transition: top 0.2s ease-in-out;
        padding: 26px 20px;
        max-width: 1000px;
        min-width: 900px;   
    }

    .content1 {
        flex: 1 9999 0%;
        min-width: 40px;
    }

    .title-image {
        flex: 0 0 auto;
        justify-content: flex-start;
        flex-direction: row;
        align-items: center;
        display: flex;
        border: 0 solid #b8b8b860;
        margin: 0;
        padding: 0;
        position: relative;
        align-content: stretch;
    }

    .column {
        background-color: #b8b8b860;
        height: 28px;
        margin: 0 16px;
        transition: opacity .1s ease-out;
        width: 1px;
    }

    h3 {
        color:darkslateblue;
        font-family:Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif
    }

    .content2 {
        flex: 1 9999 0%;
        padding: 7px;
        justify-content: center;
    }

    .content3 {
        flex: 1 0 0%;
        align-content: center;    
        align-items: center;
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: flex-end;  
    }

    .icons {
        display: flex;
        flex-direction: row;
        white-space: nowrap;
        padding-left: 24px;
        align-items: stretch
    }

    .explore-link {
        align-items: stretch;
        display: flex;
        flex-direction: column;
        box-sizing: border-box;
        flex-shrink: 0;
        margin: 0;
        padding: 0;
        position: relative;
        white-space: nowrap;
        padding-left: 20px;
    }

    .like-link {
        align-items: stretch;
        display: flex;
        flex-direction: column;
        box-sizing: border-box;
        flex-shrink: 0;
        margin: 0;
        padding: 0;
        position: relative;
        white-space: nowrap;
        padding-left: 20px;
    }

    .profile-link {
        align-items: stretch;
        display: flex;
        flex-direction: column;
        box-sizing: border-box;
        flex-shrink: 0;
        margin: 0;
        padding: 0;
        position: relative;
        white-space: nowrap;
        padding-left: 20px;
    }

    a {
        color: #ffffff
    }

    form {
        position: absolute;
        width : 46px;
        height : 46px;
        left: 50%;
        top: 50%;
        padding: 5px;
        transform: translate(-50%, -50%);
        border-radius: 50px;
        border: 4px solid rgb(221, 221, 221);
        box-sizing: border-box;
        background: #fff;
        transition: 1.0s;
    }

    input {
        position: absolute;
        top: 0;
        left: 0;
        border: 0;
        width: 100%;
        height: 38px;
        line-height: 75px;
        outline: 0;
        display: none;
        font-size: 16px;
        border-radius: 25px;
        padding: 0 20px;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    .btn{
        position: absolute;
        top: 0;
        right: 0;
        width: 38px;
        height: 38px;
        box-sizing: border-box;
        border-radius: 50%;
        text-align: center;
        font-size: 25px;
        transition: 1.0;
        background: #000000;
        padding: 10px;
    }

    form:hover {
        width: 250px;
        cursor: pointer;
    }
    form:hover input{
        display: block;
    }
</style>