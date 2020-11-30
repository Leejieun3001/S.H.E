<template>
    <main class="box" role="main">
        <div class="container">
            <header class="header-contents">
                <div class="header-content1">
                    <div class="content1">
                        <div class="merge">
                            <img alt="프로필 사진 바꾸기" class="image" :src = "u_img">
                        </div>
                    </div>
                </div>
                <section class="header-content2">
                    <div class="userinfo">
                        <h1 class="username">{{u_nickname}}</h1>
                        <a class="user-edit" href="./mypage">
                            <button class="profile-edit" type="button">프로필 편집</button>
                        </a>
                        <a class="user-edit" href="./mypage">
                            <button class="user-setting" type="button">
                                <img alt="설정" class="set-icon" fill="#262626" height="28" width="28" src = "src\assets\setting.png">
                            </button>
                        </a>
                    </div>
                    <ul class="postinfo">
                        <li class="info">
                            <span class="info-title">
                                게시물
                                <span class="info-content">{{post_count}}</span>
                            </span>
                        </li>
                        <li class="info">
                            <a class="follower" href="./">
                                팔로워
                                <span class="info-content">{{u_follower}}</span>
                            </a>
                        </li>
                        <li class="info">
                            <a class="following" href="./">
                                팔로우
                                <span class="info-content">{{u_follow}}</span>
                            </a>
                        </li>
                    </ul>
                    <div class="userMsg">
                        <h1 class="message">{{u_name}}</h1>
                        <br>
                    </div>
                    <div class="userMsg">
                        <h1 class="bio">{{u_bio}}</h1>
                        <br>
                    </div>
                </section>
            </header>
            <div class="category">
                <a class="user_category" href="./feed">
                    <span class="category_content">
                        <img alt="게시물" class="cate_img" src = "src\assets\grid.png">
                        <span class="cate_text">게시물</span>
                    </span>
                </a>
            </div>
            <div class="feeds">
                <article class="feed__list">
                    <div>
                        <!-- 스크롤에 따라 padding-bottom값 변경 -->
                        <div style="flex-direction: column; padding-bottom: 0px; padding-top: 0px;">
                            <div class="posts" v-for="(post_images, idx) in chunkedPosting" v-bind:key="idx">
                                <div class="post" v-for="(post_img, p_idx) in post_images" v-bind:key="p_idx"> 
                                    <a href="./feed">
                                        <img class="post__image" 
                                            :src="post_images[idx, p_idx].postImage" 
                                            width="293px" 
                                            height="293px"
                                            style="object-fit:cover;">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </article>
            </div>
        </div>
    </main>
</template>

<script>
import userInfo from '../data/userInfo'
import userPost from '../data/userpost'
import chunk from 'chunk'

    export default {
        name: "myfeed",
        props: {
            userInfo: Object,
            userPost: Object,
        },
        data() {
            return {
                u_img: userInfo.image,
                u_name: userInfo.name,
                u_nickname: userInfo.userName,
                u_bio: userInfo.userBio,
                u_follower: userInfo.follower,
                u_follow: userInfo.follow,
                post_count: userPost.posting.length,
                post_images: userPost.posting,
                post_img: null,
                chunkedPosting: null,
            }
        },
        created() {
                this.chunkedPosting = chunk(this.post_images, 3);
                console.log(this.chunkedPosting);
        },
    }
</script>

<style scoped>
    div, header, section, article {
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

    a, a:visited {
        text-decoration: none;
    }

    .box {
        background: #fafafa;
        flex-grow: 1;
        order: 4;
    }

    .container {
        box-sizing: content-box;
        padding: 40px 20px 0;
        width: calc(100% - 40px);
        margin-bottom: 0;
        flex-grow: 1;
        margin: 0 auto 30px;
        max-width: 935px;
    }

    .header-contents {
        margin-bottom: 35px;
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
        display:flex;
        align-items: center;
        flex-direction: row;
        justify-content: flex-start;
        flex-shrink: 1;
        min-width: 0;
        margin-bottom:5px;
    }

    .username {
        display: block;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        color: #424242;
        font-weight: 200;
        font-size: 30px;
        line-height: 32px;
        margin: -5px 0 -6px;
        font-family: inherit;
    }

    .user-edit {
        flex-shrink: 0;
        margin-left: 20px;
        display: block;
    }

    .profile-edit {
        background-color: #fafafa;
        border: 1px solid #8f8e8e;
        color: #000000;
        width: 100%;
        border-radius: 4px;
        position: relative;
        box-sizing: content-box;
        cursor: pointer;
        display: block;
        font-weight: 600;
        padding: 5px 9px;
        text-align: center;
        text-transform: inherit;
        text-overflow: ellipsis;
        user-select: none;
    }

    .user-setting {
        display: block;
        background: 0 0;
        border: 0;
        cursor: pointer;
        justify-content: left;
        margin-left: 8px;
    }

    .postinfo {
        margin-bottom: 14px;
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

    .category {
        align-items: center;
        border-top: 1px solid rgba(var(--b38,219,219,219),1);
        color: #999;
        display: flex;;
        flex-direction: row;
        font-size: 12px;
        font-weight: 600;
        justify-content: center;
        letter-spacing: 1px;
        text-align: center;
    }

    .user_category {
        align-items: center;
        color: #262626;
        margin-right: 60px;
        border-top: 1px solid #262626;
        margin-top: -1px;
        cursor: pointer;
        display: flex;
        flex-direction: row;
        height: 52px;
        justify-content: center;
        text-transform: uppercase;
    }

    .category_content {
        display: flex;
        align-items: center;
    }

    .cate_img {
        display: block;
        position: relative;
        height: 17px;
        width: 17px;
        margin-top: 3px;
        margin-bottom: 5px;
    }   

    .cate_text {
        margin-left: 6px;
    } 

    .feed__list {
        flex-grow: 1;
    }

    .posts {
        flex-direction: row;
        margin-bottom: 28px;
        text-align: left;
    }

    .post {
        display: inline;
        position: relative;
        margin-right: 28px;
    }

    .bio {
        margin-top: 3px;
        font-size: 14px;
        font-weight: 200;
        color: #424242;
    }
    
</style>
