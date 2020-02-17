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
            <sui-search
            input
            placeholder="검색"
            :source="source"
            v-model="valueSelectIcon"
            >
            <i slot="icon" class="search icon"></i>
            </sui-search>
          </div>
          <div class="content3">
              <div class="icons">
                  <div class="explore-link">
                    <a href="./">\
                        <img src="src\assets\explore.png" alt="explore-icon" width="25px" height="25px"/>
                    </a>
                  </div>
                  <div class="like-link">
                    <a href="./">\
                        <img src="src\assets\like.png" alt="like-icon" width="25px" height="25px"/>
                    </a>
                  </div>
                  <div class="profile-link">
                    <a href="./">\
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
        name: "header-content",
        data() {
            return {
            valueBasic: null,
            valueSelectIcon: null,
            source: [
                { name: 'Horse' },
                { name: 'Parrot' },
                { name: 'Cat' },
                { name: 'Catfish' },
            ]};
        },
    };
</script>

<style scoped>
    .box {
        width: 100%;
        height: 77px;
        margin: 10px 10px 10px 10px;
        text-align: center;
        position: fixed; 
        border-bottom: 1px solid #b8b8b860;
        top: 0;
        background: #ffffff;
        transition: top 0.2s ease-in-out;
        align-items: center;
        flex-direction: column;
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
        max-width: 975px;
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

    .content3 {
        flex: 1 0 0%;
        align-content: center;    
        align-items: center;
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: flex-end;        
        padding-right : 50px;
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

</style>
