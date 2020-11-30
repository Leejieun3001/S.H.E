<template>
    <main class="contents" role="main">
        <div class="container">
            <ul class="title-list">
                <li>
                    <a class="list unselect" href="./mypage">프로필 편집</a>
                </li>
                <li>
                    <a class="list select" href="./pwdchange">비밀번호 변경</a>
                </li>
            </ul>
            <article class="main-contents">
                <div class="profile">
                    <div class="profile__image">
                        <img alt="프로필 사진" class="img_change proImg" :src="u_img">
                    </div>
                    <div class="profile__text">
                        <h1 class="profile__text__username" title="los.eel">los.eel</h1>
                    </div>
                </div>
                <form @submit.prevent="submit" class="form__list" method="POST">
                    <div class="form__list__contents">
                        <aside class="form__list__title">
                            <label for="oldPwd">이전 비밀번호</label>
                        </aside>
                        <div class="form__list__input">
                            <input autocomplete="current-password" 
                                    class="password" 
                                    id="OldPassword" 
                                    name="OldPassword" 
                                    required 
                                    spellcheck="true" 
                                    type="password" 
                                    v-model="curPwd"/>
                        </div>
                    </div>
                    <div class="form__list__contents">
                        <aside class="form__list__title">
                            <label for="newPwd">새 비밀번호</label>
                        </aside>
                        <div class="form__list__input">
                            <input autocomplete="new-password" 
                                    class="password" 
                                    id="NewPassword" 
                                    name="NewPassword" 
                                    required 
                                    spellcheck="true" 
                                    type="password" 
                                    v-model="newPwd">
                        </div>
                    </div>
                    <div class="form__list__contents">
                        <aside class="form__list__title">
                            <label for="cfmPwd">비밀번호 확인</label>
                        </aside>
                        <div class="form__list__input">
                            <input autocomplete="new-password" 
                                    class="password" 
                                    id="ConfirmPwd" 
                                    name="ConfirmPwd" 
                                    required 
                                    spellcheck="true" 
                                    type="password" 
                                    v-model="cfmPwd">
                            <div class="alert alert-success" id="alert-success" style="display:none">비밀번호가 일치합니다.</div> 
                            <div class="alert alert-danger" id="alert-danger" style="display:none">비밀번호가 일치하지 않습니다.</div>
                        </div>
                    </div>
                    <div class="form__list__contents">
                        <aside class="form__list__title">
                            <label></label>
                        </aside>
                        <div class="form__list__input">
                            <div class="submit">
                                <button class="submit__btn" 
                                        v-bind:disabled="curPwd==='' || newPwd==='' || cfmPwd===''">비밀번호 변경
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
            </article>
        </div> 
    </main>
</template>

<script>
import userInfo from '../data/userInfo'

var qs = require('qs')

    export default {
        name: "mypage",
        props: {
            userInfo: Object
        },
        data() {
            return {
                u_img: userInfo.image,
                u_pwd: userInfo.pwd,
                curPwd: '',
                newPwd: '',
                cfmPwd: '',
                filled: true,
                result: null
            }
        },
        
        methods: {
            submit(e) {
                // post url : 서버 주소 
                this.$axios.post('/api/data', qs.stringify({newPwd : this.newPwd}),
                {
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                })
                .then(res => { 
                    console.log(res); 
                    this.result = res.data
                }).catch(err => {
                    console.warn("ERROR : ", err)
                })
            },
            sameListener() {
                
            }
        }
    }
</script>

<style scoped>
    main, div, header, section, nav, article {
        align-items: stretch;
        border: 0 solid #000000;
        box-sizing: border-box;
        display: flex;
        flex-direction: column;
        flex-shrink: 0;
        margin: 0;
        padding: 0;
        position: relative;
    }

    button, input {
        color: #262626;
        font-family: "Segoe UI",Helvetica,Arial,sans-serif;
        font-size: 14px;
        line-height: 18px;
    }

    input[type="file" i] {
        background-color: initial;
        cursor: default;
        align-items: baseline;
        text-align: start !important;
        padding: initial;
        border: initial;
    }

    input {
        text-rendering: auto;
        letter-spacing: normal;
        word-spacing: normal;
        text-transform: none;
        text-indent: 0px;
        text-shadow: none;
        margin: 0em;
        font: 400 13.3333px Arial;
    }

    button {
        text-rendering: auto;
        letter-spacing: normal;
        word-spacing: normal;
        text-transform: none;
        text-indent: 0px;
        text-shadow: none;
        display: inline-block;
        text-align: center;
        align-items: flex-start;
        box-sizing: border-box;
        margin: 0em;
        font: 400 13.3333px Arial;
    }

    ul {
        list-style: none;
        display: block;
        margin-block-start: 1em;
        margin-block-end: 1em;
        margin-inline-start: 0px;
        margin-inline-end: 0px;
        padding-inline-start: 40px;
    }

    li {
        display: list-item;
        text-align: match-parent;
    }

    a, ul, span, li, article, img, form, h1, h2 {
        margin: 0;
        padding: 0;
        border: 0;
        font-family: "Segoe UI",Helvetica,Arial,sans-serif;
        vertical-align: baseline;  
    }

    form {
        display: block;
    }

    a, a:visited {
        text-decoration: none;
    }

    .contents {
        background-color : #fafafa;
        flex-grow: 1;
        order: 4;
    }

    .container {
        background-color : #ffffff;
        border: 1px solid #dbdbdb;
        border-radius: 3px;
        margin: 60px auto 0;
        max-width: 935px;
        overflow: hidden;
        width: 100%;    
        flex-direction: row;
        flex-grow: 1;
        justify-content: stretch;   
    }

    .title-list {
        border-right: 1px solid #dbdbdb;
        flex-basis: 236px;
        flex-grow: 0;
        flex-shrink: 0;
    }

    .list {
        color: #262626;
        border-left: 2px solid transparent;
        display: block;
        font-size: 16px;
        height: 100%;
        line-height: 20px;
        padding: 16px 16px 16px 30px;
        width: 100%;
        text-align: left;
    }

    .select {
        border-left-color: #262626;
        font-weight: 600; 
    }

    .main-contents {
        flex: 1 1 400px;
        min-width: 50px;
    }

    .profile {
        flex-direction: row;
        margin: 32px 0 0;
        justify-content: flex-start;
    }

    .profile__image {
        margin: 2px 32px 0 124px;
        height: 38px;
        width: 38px;
    }

    .profile__image-btn {
        background-color: #fafafa;
        border-radius: 50%;
        box-sizing: border-box;
        margin: 0 auto;
        overflow: hidden;
        position: relative;
        height: 100%;
        width: 100%;
    }

    .change {
        border: 0;
        cursor: pointer;
        padding: 0;
        height: 100%;
        width: 100%;
    }

    .img_change {
        height: 100%;
        left: 0;
        position: absolute;
        top: 0;
        width: 100%;
    }

    .img_input {
        display: none!important;
    }

    .profile__text {
        flex: 0 1 auto;
        margin-right: 20px;
        overflow-x: hidden;
        align-items: center;
    }

    .profile__text__username {
        font-size: 23px;
        line-height: 22px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        font-weight: 400;
        text-align: center;
        margin-top: 8px;
    }

    .profile__text__change {
        border: 0;
        color: rgba(var(--h5f,56,151,240),1);
        display: inline;
        padding: 0;
        position: relative;
        background: 0 0;
        box-sizing: border-box;
        cursor: pointer;
        font-weight: 600;
        text-transform: inherit;
        text-overflow: ellipsis;
        user-select: none;
    }

    .form__list {
        align-items: stretch;
        display: flex;
        flex-direction: column;
        margin-bottom: 16px;
        margin-top: 16px;
    }

    .form__list__contents {
        flex-direction: row;
        margin-bottom: 16px;
        justify-content: flex-start;
    }

    .form__list__title {
        padding-left: 32px;
        padding-right: 32px;
        text-align: right;
        box-sizing: border-box;
        color: #262626;
        flex: 0 0 194px;
        font-size: 16px;
        font-weight: 600;
        line-height: 18px;
        margin-top: 11px;
    }

    .form__list__input {
        flex-basis: 355px;
        flex-direction: row;
        padding-right: 60px;
        color: #262626;
        flex-grow: 1;
        font-size: 16px;
        justify-content: flex-start;
    }

    .form__input {
        background: 0 0;
        border: 1px solid #dbdbdb;
        border-radius: 3px;
        box-sizing: border-box;
        color: #262626;
        flex: 0 1 355px;
        font-size: 16px;
        height: 32px;
        padding: 0 10px;
    }

    .form__textarea {
        background: 0 0;
        border: 1px solid #dbdbdb;
        border-radius: 3px;
        box-sizing: border-box;
        color: #262626;
        color: rgba(var(--i1d,38,38,38),1);
        flex: 0 1 355px;
        font-size: 16px;
        height: 60px;
        padding: 6px 10px;
        resize: vertical;
    }

    .form__text {
        margin-top: 16px;
        flex: 0 0 auto;
        justify-content: flex-start;
        align-items: stretch;
        align-content: stretch;
    }

    .form__text__deco {
        color: #999;
        font-size: 14px;
        font-weight: 600;
    }

    .submit {
        align-items: center;
        flex-direction: row;
        margin-top: 16px;
    }

    .submit__btn[disabled] {
        background-color: #3897f04d;
        opacity: 1;
    }

    .submit__btn {
        background: 0 0;
        box-sizing: border-box;
        cursor: pointer;
        display: block;
        font-weight: 600;
        padding: 5px 9px;
        text-align: center;
        text-transform: inherit;
        text-overflow: ellipsis;
        user-select: none;
        width: auto;
        border-radius: 4px;
        color: #fff;
        position: relative;
        background-color: #3897f0;
        border: 1px solid transparent;
        font-size: 14px;
    }

    .proImg {
        background-color: #fafafa;
        border-radius: 50%;
        box-sizing: border-box;
        margin: 0 auto;
        overflow: hidden;
        position: relative;
        height: 100%;
        width: 100%;
    }

    .password {
        outline: 0!important;
        background: #fafafa;
        border-radius: 6px;
        border: 1px solid #dbdbdb;
        color: #262626;
        flex-grow: 1;
        font-size: 14px;
        line-height: 30px;
        margin: 0;
        overflow: visible;
        padding: 4px 12px;
    }

    .unselect:hover {
        border-left-color: #929292;
        background-color: #f7f7f7;
    }

</style>