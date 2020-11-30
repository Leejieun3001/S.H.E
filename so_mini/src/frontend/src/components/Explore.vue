<template>
    <main class="box" role="main">
        <header class="container">
            <div class="container__image" style="width: 152px; height: 152px;">
                <img class="search__image" src="src\assets\result.jpg" alt="검색 결과">
            </div>
            <div class="container__content">
                <div class="content__info">
                    <div class="info tag">
                        <h1 class="hashtag__title">
                            #
                            <!-- {{searchInfo.word}} -->
                            아이유
                        </h1>
                    </div>
                    <div class="info post">
                        <span class="info__title">
                            게시물
                            <span class="info__count">
                                <!-- {{searchInfo.count}} -->
                                739,617
                            </span>
                        </span>
                    </div>
                </div>
                <div class="content__related">
                    <span class="r__span related__span">
                        <span class="r__span span__tag">
                            관련 해시태그
                        </span>
                        <span class="r__span related__tag">
                            <!-- <div class="hashtag" v-for="(tag, idx) in r_tags" v-bind:key="idx"> -->
                            <div class="hashtag">
                                <!-- href="/explore/tags/이지금/" -->
                                <a class="hashtag__link" href="#">#이지금</a>
                            </div>
                        </span>
                    </span>
                </div>
            </div>
        </header>
        <article class="content">
            <div class="popular">
                <h2 class="popular__text">
                    <div class="popular__post">인기 게시물</div>
                </h2>
                <div>
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
            </div>
            <h2 class="popular__text">
                최근 사진
            </h2>
            <div>
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
    </main>
</template>

<script>
import userInfo from '../data/userInfo'
import userPost from '../data/userpost'
import chunk from 'chunk'

export default {
    name: "explore",
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
    a, a:visited {
        color: #003569;
        text-decoration: none;
    }

    .container {
        margin: 30px auto 30px;
        align-items: center;
        display: flex;
        flex-direction: row;
        font-size: 16px;
        line-height: 24px;
        max-width: 935px;
        width: 100%;
        color: #262626;
        text-align: center;
    }

    article, div, footer, header, main, nav, section {
    align-items: stretch;
    border: 0 solid #000;
    box-sizing: border-box;
    display: flex;
    flex-direction: column;
    flex-shrink: 0;
    margin: 0;
    padding: 0;
    position: relative;
    }

    .container__image {
        background-color: #fafafa;
        border-radius: 50%;
        box-sizing: border-box;
        display: block;
        flex: 0 0 auto;
        overflow: hidden;
        position: relative;
    }

    .search__image {
        height: 100%;
        width: 100%;
    }

    .search__image::after {
        border: 1px solid #000;
        border-radius: 50%;
        bottom: 0;
        content: "";
        left: 0;
        pointer-events: none;
        position: absolute;
        right: 0;
        top: 0;
    }

    .container__content {
        max-width: 935px;
        width: 100%;
        text-align: left center;
    }

    .content__info {
        margin-left: 50px;
        text-align: left;
    }

    .info {
        flex: 0 0 auto;
        justify-content: flex-start;
        align-items: stretch;
        align-content: stretch;
    }

    .tag {
        margin-bottom: 12px;
    }

    .hashtag__title {
        display: block;
        color: #262626;
        font-weight: 300;
        font-size: 28px;
        line-height: 32px;
        margin: -5px 0 -6px;
    }

    .post {
        margin-bottom: 18px;
    }

    .info__title {
        color: inherit;
    }

    .info__count {
        color: #262626;
        font-weight: 600;
    }

    .content__related {
        margin-left: 48px;
        flex-wrap: wrap;
        flex: 1 1 auto;
        min-height: 0;
        min-width: 0;
        justify-content: flex-start;
        flex-direction: row;
        align-items: stretch;
        align-content: stretch;
    }

    .related__span {
        color: #262626;
        overflow-wrap: break-word;
        white-space: normal;
    }

    .r__span {
        overflow-wrap: break-word;
        white-space: normal;
        display: inline!important;
        margin: 0!important;
        font-weight: 400;
        font-size: 14px;
        line-height: 18px;
    }

    .span__tag {
        color: #999;
    }

    .related__tag {
        color: #262626;
    }

    .hashtag {
        padding-bottom: 4px;
        padding-top: 4px;
        flex-wrap: wrap;
        flex: 0 0 auto;
        justify-content: flex-start;
        align-items: stretch;
        align-content: stretch;
        display: inline-block;
    }

    .hashtag__link {
        word-wrap: break-word;
        color: #003569;
        font-weight: 300;
        padding: 0 3px;
    }
    
    .content {
        box-sizing: content-box;
        padding: 0 20px;
        width: calc(100% - 40px);
        flex-grow: 1;
        margin: 0 auto 30px;
        max-width: 935px;
    }

    .popular {
        margin-bottom: 74px;
    }

    .popular__text {
        color: #999;
        font-size: 14px;
        font-weight: 600;
        line-height: 18px;
        margin-bottom: 16px;
        text-align: left;
        display: block;
        margin-block-start: 0.83em;
        margin-block-end: 0.83em;
        margin-inline-start: 0px;
        margin-inline-end: 0px;
    }

    .popular__post {
        display: flex;
        flex-direction: row;
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

</style>
