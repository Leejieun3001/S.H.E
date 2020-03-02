<template>
    <main class="box" role="main">
        <div class="container">
            <header class="header-contents">
                <div class="header-content1">
                    <div class="content1">
                        <div class="merge">
                            <button class="btn" title="프로필 사진 바꾸기">
                                <img alt="프로필 사진 바꾸기" class="image" src = "src\assets\s_profile.jpg">
                            </button>
                            <div>
                                <form enctype="multipart/form-data" method="POST" role="presentation">
                                    <input accept="image/jpeg, image/png" class = "img-form" type="file">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <section class="header-content2">
                    <div class="userinfo">
                        <h1 class="username">los.eel</h1>
                        <a class="user-edit" href="./">
                            <button class="profile-edit" type="button">프로필 편집</button>
                        </a>
                        <div class="setting">
                            <button class="user-setting" type="button">
                                <img alt="설정" class="set-icon" fill="#262626" height="24" width="24" src = "src\assets\setting.png">
                            </button>
                        </div>
                    </div>
                    <ul class="postinfo">
                        <li class="info">
                            <span class="info-title">
                                게시물
                                <span class="info-content">146</span>
                            </span>
                        </li>
                        <li class="info">
                            <a class="follower" href="./">
                                팔로워
                                <span class="info-content" title="21">21</span>
                            </a>
                        </li>
                        <li class="info">
                            <a class="following" href="./">
                                팔로우
                                <span class="info-content">23</span>
                            </a>
                        </li>
                    </ul>
                    <div class="userMsg">
                        <h1 class="message">los.eel</h1>
                        <br>
                    </div>
                </section>
            </header>
        </div>
        <div class="feeds">
                <article class="feed-list">
                    <div>
                        <div style="flex-direction: column; padding-bottom: 2637px; padding-top: 0px">
                            <div class="posts">
                                <div class="post">
                                </div>
                            </div>
                        </div>
                    </div>
                </article>
            </div>
    </main>
</template>

<script>
    export default {
        name: "feed"
    }
</script>

<style scoped>
    div, header, section {
        align-items: stretch;
        box-sizing: border-box;
        display: flex;
        flex-direction: column;
        flex-shrink: 0;
        margin: 0;
        padding: 0;
        position: relative;
        font : inherit;
        vertical-align: baseline;
    }

    img, form, h1, ul, li, span {
        margin: 0;
        padding: 0;
        border: 0;
        font: inherit;
        vertical-align: baseline;
    }

    form {
        display: block;
    }

    button {
        font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        font-size: 14px;
        line-height: 18px;
        text-rendering: auto;
        letter-spacing: normal;
        word-spacing: normal;
        text-indent: 0px;
        text-shadow: none;
        align-items: flex-start;
        margin: 0em;
        font: 400 13.3333px Arial;
    }

    ul {
        list-style: none;
        margin-block-start: 1em;
        margin-block-end: 1em;
        margin-inline-start: 0px;
        margin-inline-end: 0px;
    }

    li {
        display: list-item;
        text-align: center;
    }

    h1 {
        margin-inline-start: 0px;
        margin-inline-end: 0px;
    }

    .box {
        background: #f1f1f1;
        flex-grow: 1;
        order: 4;
    }

    .container {
        box-sizing: content-box;
        padding: 80px 20px 0;
        width: calc(100% - 40px);
        margin-bottom: 0;
        flex-grow: 1;
        margin: 0 auto 30px;
        max-width: 935px;
        border-bottom: 1px solid #c2c2c2;
    }

    .header-contents {
        margin-bottom: 44px;
        flex-direction: row;
    }

    .header-content1 {
        flex-basis: 0;
        flex-grow: 1;
        margin-right: 30px;
        flex-shrink: 0;
    }

    .content1 {
        height: 150px;
        width: 150px;
        display: block;
        margin-right: auto;
        margin-left: auto;
    }

    .merge {
        color : #ffffff;
        border-radius: 50%;
        box-sizing: border-box;
        margin: 0 auto;
        overflow: hidden;
        position: relative;
        height: 100%;
        width: 100%;
    }    
    
    .merge::after {
        border: 1px solid #9e9e9e;
        border-radius: 50%;
        bottom: 0;
        content: "";
        left: 0;
        pointer-events: none;
        position: absolute;
        right: 0;
        top: 0;
    }

    .btn {
        border: 0;
        cursor: pointer;
        padding: 0;
        height: 100%;
        width: 100%;
    }

    .image {
        height: 100%;
        left: 0;
        position: absolute;
        top: 0;
        width: 100%;
        
    }

    .img-form {
        display: none!important;
        background-color: initial;
        cursor: default;
        align-items: baseline;
        text-align: start !important;
        padding: initial;
        border: initial;
    }

    .header-content2 {
        flex-basis: 30px;
        flex-grow: 2;
        flex-shrink: 1;
        min-width: 0;
    }

    .userinfo {
        margin-bottom: 10px;
        align-items: center;
        flex-direction: row;
        flex-shrink: 1;
        min-width: 0;
    }

    .username {
        display: block;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        color: #424242;
        font-weight: 300;
        font-size: 28px;
        line-height: 32px;
        margin: -5px 0 -6px;
    }

    .user-edit {
        flex-shrink: 0;
        margin-left: 20px;
        display: block;
    }

    .profile-edit {
        background-color: #f1f1f1;
        border: 1px solid #8f8e8e;
        color: #000000;
        width: 100%;
        border-radius: 4px;
        position: relative;
        box-sizing: border-box;
        cursor: pointer;
        display: block;
        font-weight: 600;
        padding: 5px 9px;
        text-align: center;
        text-transform: inherit;
        text-overflow: ellipsis;
        user-select: none;
    }

    .setting {
        flex-direction: row;
        flex-shrink: 0;
        margin-left: 5px;
    }

    .user-setting {
        align-items: center;
        background: 0 0;
        border: 0;
        cursor: pointer;
        display: flex;
        justify-content: center;
        padding: 8px;
    }

    .set-icon {
        display: block;
        position: relative;
    }

    .postinfo {
        margin-bottom: 20px;
        display: flex;
        flex-direction: row;
    }

    .info {
        font-size: 16px;
        margin-right: 40px;
    }

    .info-title, .follower, .following, .message {
        color: #383838;
    }

    .info-content {
        color: #383838;
        font-weight: 600;
    }

    .userMsg {
        font-size: 16px;
        line-height: 24px;
        word-wrap: break-word;
        display: block;
        text-align: left;
    }

    .message {
        display: inline;
        font-weight: 600;
        color: #424242;
    }
</style>
