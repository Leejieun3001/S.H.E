<template>
    <main class="contents" role="main">
        <div class="container">
            <ul class="title-list">
                <li>
                    <a class="list select" href="./">프로필 편집</a>
                </li>
                <li>
                    <a class="list" href="./">비밀번호 변경</a>
                </li>
            </ul>
            <article class="main-contents">
                <div class="profile">
                    <div class="profile__image">
                        <div class="profile__image-btn">
                            <button class="change" title="프로필 사진 바꾸기">
                                <img alt="프로필 사진 바꾸기" class="img_change" :src="userInfo.image">
                            </button>
                            <div>
                                <form enctype="multipart/form-data" method="POST" role="presentation">
                                    <input accept="image/jpeg,image/png" class="img_input" type="file">
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="profile__text">
                        <h1 class="profile__text__username" title="los.eel">los.eel</h1>
                        <button class="profile__text__change" type="button">프로필 사진 바꾸기</button>
                        <div>
                            <form enctype="multipart/form-data" method="POST" role="presentation">
                                 <input accept="image/jpeg,image/png" class="img_input" type="file">
                            </form>
                        </div>
                    </div>
                </div>
                <form class="form__list" method="POST">
                    <div class="form__list__contents">
                        <aside class="form__list__title">
                            <label for="name">이름</label>
                        </aside>
                        <div class="form__list__input">
                            <input aria-required="false" id="name" type="text" class="form__input" :value="userInfo.name">
                        </div>
                    </div>
                    <div class="form__list__contents">
                        <aside class="form__list__title">
                            <label for="userName">사용자 이름</label>
                        </aside>
                        <div class="form__list__input">
                            <input aria-required="true" id="userName" type="text" class="form__input" :value="userInfo.userName">
                        </div>
                    </div>
                    <div class="form__list__contents">
                        <aside class="form__list__title">
                            <label for="userBio">소개</label>
                        </aside>
                        <div class="form__list__input">
                            <textarea class="form__textarea" id="userBio" :value="userInfo.userBio"></textarea>
                        </div>
                    </div>
                    <div class="form__list__contents">
                        <aside class="form__list__title">
                            <label></label>
                        </aside>
                        <div class="form__list__input">
                            <div class="form__text" style="max-width:355px;">
                                <h2 class="form__text__deco">개인 정보</h2>
                            </div>
                        </div>
                    </div>
                    <div class="form__list__contents">
                        <aside class="form__list__title">
                            <label for="userEmail">이메일</label>
                        </aside>
                        <div class="form__list__input">
                            <input aria-required="false" id="userEmail" type="text" class="form__input" :value="userInfo.email">
                        </div>
                    </div>
                    <div class="form__list__contents">
                        <aside class="form__list__title">
                            <label for="phoneNumber">전화번호</label>
                        </aside>
                        <div class="form__list__input">
                            <input aria-required="false" id="phoneNumber" type="text" class="form__input" :value="userInfo.phoneNumber">
                        </div>
                    </div>
                    <div class="form__select__gender">
                        <div class="form__list__contents">
                            <aside class="form__list__title">
                                <label for="gender">성별</label>
                            </aside>
                            <div class="form__list__input">
                                <div class="gender__select" style="max-width:355px;">
                                    <button class="gender__btn" type="button">
                                        <input readonly type="text" class="gender__text" value="여성">
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form__list__contents">
                        <aside class="form__list__title">
                            <label></label>
                        </aside>
                        <div class="form__list__input">
                            <div class="submit">
                                <button class="submit__btn" type="button">제출</button>
                            </div>
                        </div>
                    </div>
                </form>
            </article>
        </div> 
    </main>
</template>

<script>
    export default {
        name: "mypage",
        props: {
            userInfo: Object
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
        width: calc(100% - 48px);
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

    .profile__image-btn::after {
        border: 1px solid rgba(0,0,0,.0975);
        border-radius: 50%;
        bottom: 0;
        content: "";
        left: 0;
        pointer-events: none;
        position: absolute;
        right: 0;
        top: 0;
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
    }

    .profile__text>button {
        text-align: left;
    }

    .profile__text__username {
        font-size: 20px;
        line-height: 22px;
        margin-bottom: 2px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        font-weight: 400;
        text-align: left;
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
        margin-top: 6px;
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

    .form__select__gender {
        flex: 0 0 auto;
        justify-content: flex-start;
        align-items: stretch;
        align-content: stretch;
    }

    .gender__select {
        flex: 1 1 auto;
        min-height: 0;
        min-width: 0;
        justify-content: flex-start;
        align-items: flex-start;
        align-content: stretch;
    }

    .gender__btn {
        color: #262626;
        border: 0;
        color: #3897f0;
        display: inline;
        padding: 0;
        position: relative;
        background-color: transparent;
        width: 100%;
        background: 0 0;
        box-sizing: border-box;
        cursor: pointer;
        font-weight: 600;
        text-align: center;
        text-transform: inherit;
        text-overflow: ellipsis;
        user-select: none;
    }

    .gender__text {
        background: 0 0;
        border: 1px solid #dbdbdb;
        border-radius: 3px;
        box-sizing: border-box;
        color: #262626;
        flex: 0 1 355px;
        font-size: 16px;
        height: 32px;
        padding: 0 10px;
        width: 100%;
    }

    .submit {
        align-items: center;
        flex-direction: row;
        margin-top: 16px;
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
    }

</style>