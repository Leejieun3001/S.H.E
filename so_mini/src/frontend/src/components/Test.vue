<template>
  <div id="app">
    <div class="app__phone">
      <div class="phone-header">
        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/Instagram_logo.png" />
        <p class="cancel-cta" v-if="step === 2 || step === 3" @click="goToHome">Cancel</p>
        <p class="next-cta" v-if="step === 2" @click="step++">Next</p>
        <p class="next-cta" v-if="step === 3" @click="sharePost">Share</p>
      </div>
      <transition name="fade">
        <div class="feed" v-if="step === 1" v-dragscroll.y="true">
          <instagram-post v-for="post in posts"
                          :post="post"
                          :key="posts.indexOf(post)">
          </instagram-post>
        </div>
      </transition>
      <div v-if="step === 2">
        <div class="selected-image"
             :class="filterType"
             :style="{ backgroundImage: 'url(' + image + ')' }"></div>
        <div class="filter-container" v-dragscroll.x="true">
          <filter-type v-for="filter in filters"
                       :filter="filter"
                       :image="image"
                       :key="filter.name">
          </filter-type>
        </div>
      </div>
      <div v-if="step === 3">
        <div class="selected-image"
             :class="filterType"
             :style="{ backgroundImage: 'url(' + image + ')' }"></div>
        <div class="caption-container">
        <textarea class="caption-input"
                  placeholder="Write a caption..."
                  type="text"
                  v-model="caption">
        </textarea>
        </div>
      </div>
      <div class="phone-footer">
        <div class="home-cta" @click="goToHome">
          <i class="fas fa-home fa-lg"></i>
        </div>
        <div class="upload-cta">
          <input type="file"
                 name="file"
                 id="file"
                 class="inputfile"
                 @change="fileUpload"
                 v-model="fileInput"
                 :disabled="step !== 1"/>
          <label for="file">
            <i class="far fa-plus-square fa-lg"></i>
          </label>
          <p v-if="step === 1">
            Click <a @click="uploadRandomImage">here for a random image!</a> or upload your own! <i class="fas fa-chevron-right"></i>
          </p>
        </div>
      </div>
    </div>
    <div class="details">
      <a class="button is-primary is-small is-info" v-if="!showDetails" @click="showDetails = !showDetails">Details</a>
      <ul v-else>
        <li>Navigate the feed by <span>dragging (or scrolling)</span></li>
        <li>Upload an image with <span><i class="far fa-plus-square fa-lg"></i></span></li>
        <li>Like a post with <span><i class="far fa-heart fa-lg"></i></span> or <span>double clicking an image</span></li>
      </ul>
    </div>
    <a href="https://twitter.com/djirdehh" target="_blank" class="twitter-section">
      <i class="fab fa-twitter" aria-hidden="true"></i>
      <a>
  </div>

  <!--  Prefetch random images -->
  <link rel="prefetch" href="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/tropical_beach.jpg" />
  <link rel="prefetch" href="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/downtown.jpg" />
  <link rel="prefetch" href="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/cat.jpg" />
  <link rel="prefetch" href="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/sushi.jpg" />
  <link rel="prefetch" href="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/pug_personal.jpg" />
  <link rel="prefetch" href="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/pineapple.jpg" />
  <link rel="prefetch" href="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/tropical_ocean.jpg" />
  <link rel="prefetch" href="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/velvet_monkey.jpg" />
  <link rel="prefetch" href="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/codepen_logo.png" />
  <link rel="prefetch" href="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/me2.png" />
  <link rel="prefetch" href="https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/me_3.jpg" />

</template>

<script>
  const EventBus = new Vue();

  const posts = [
    {
      username: 'socleansofreshh',
      userImage: 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/me_3.jpg',
      postImage: 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/tropical_beach.jpg',
      likes: 36,
      upVoted: false,
      caption: "When you're too ready for summer '18 ☀️",
      filter: 'perpetua'
    },
    {
      username: 'djirdehh',
      userImage: 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/me2.png',
      postImage: 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/downtown.jpg',
      likes: 20,
      upVoted: false,
      caption: 'Views from the six...',
      filter: 'clarendon'
    },
    {
      username: 'puppers',
      userImage: 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/pug_personal.jpg',
      postImage: 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/puppers.jpg',
      likes: 49,
      upVoted: false,
      caption: 'Current mood 🐶',
      filter: 'lofi'
    }
  ]

  const filters = [
    { name: 'normal' }, { name: 'clarendon' }, { name: 'gingham' }, { name: 'moon' }, { name: 'lark' }, { name: 'reyes' }, { name: 'juno' }, { name: 'slumber' }, { name: 'aden' }, { name: 'perpetua' }, { name: 'mayfair' }, { name: 'rise' }, { name: 'hudson' }, { name: 'valencia' }, { name: 'xpro2' }, { name: 'willow' }, { name: 'lofi' }, { name: 'inkwell' }, { name: 'nashville' }
  ]

  Vue.component('instagram-post', {
    template:
      `
    <div class="instagram-post">
      <div class="header level">
          <div class="level-left">
            <figure class="image is-32x32">
              <img :src="post.userImage" />
            </figure>
            <span class="username">{{post.username}}</span>
          </div>
      </div>
      <div class="image-container"
           :class="post.filter"
           :style="{ backgroundImage: 'url(' + post.postImage + ')' }"
           @dblclick="like">
      </div>
      <div class="content">
        <div class="heart">
          <i class="far fa-heart fa-lg"
            :class="{'fas': !this.post.upVoted,  'fas': this.post.upVoted}"
            @click="like">
          </i>
        </div>
        <p class="likes">{{post.likes}} likes</p>
        <p class="caption"><span>{{post.username}}</span> {{post.caption}}</p>
      </div>
    </div>
  `,
    props: ['post'],
    methods: {
      like() {
        this.post.upVoted ? this.post.likes-- : this.post.likes++;
        this.post.upVoted = !this.post.upVoted;
      }
    }
  });

  Vue.component('filter-type', {
    template:
      `
   <div class="filter-type">
     <p>{{filter.name}}</p>
    <div class="img"
         :class="filter.name"
         :style="{ backgroundImage: 'url(' + image + ')' }"
         @click="selectFilter">
    </div>
   </div>
  `,
    props: ['filter', 'image'],
    methods: {
      selectFilter() {
        EventBus.$emit('selectFilter', {filter: this.filter.name});
      }
    }
  });

  new Vue({
    el: "#app",
    data: {
      posts,
      image: 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/downtown.jpg',
      caption: '',
      filterType: 'normal',
      step: 1,
      showDetails: false,
      fileInput: ''
    },
    created () {
      EventBus.$on('selectFilter', (evt) => {
        this.filterType = evt.filter;
      })
    },
    methods: {
      fileUpload(e) {
        const files = e.target.files || e.dataTransfer.files;
        if (!files.length) return;
        this.image = files[0];
        this.createImage();
      },
      createImage() {
        const image = new Image();
        const reader = new FileReader();

        reader.onload = e => {
          this.image = e.target.result;
          this.step = 2;
        };
        reader.readAsDataURL(this.image);
      },
      uploadRandomImage() {
        const randomImages = [
          'https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/cat.jpg',
          'https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/sushi.jpg',
          'https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/velvet_monkey.jpg',
          'https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/pineapple.jpg',
          'https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/tropical_ocean.jpg'
        ];

        this.image = randomImages[Math.floor(Math.random() * randomImages.length)];
        this.step = 2;
      },
      goToHome() {
        this.image = 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/downtown.jpg';
        this.caption = '';
        this.filterType = 'normal';
        this.step = 1;
      },
      sharePost() {
        const post = {
          username: 'codepen',
          userImage: 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/1211695/codepen_logo.png',
          postImage: this.image,
          likes: 0,
          caption: this.caption,
          filter: this.filterType
        }

        this.posts.unshift(post);
        this.goToHome();
      }
    }
  });

</script>

<style scoped>
  /*$small: 520px;*/
  /*$medium: 768px;*/
  /*$large: 1216px;*/

  @import url('https://fonts.googleapis.com/css?family=Roboto:400,700');

  html, body, #app {
    height: 100%;
    margin: 0;
    overflow: hidden;
    background: #e6ecf1;
    font-family: 'Roboto', sans-serif;
  }

  #app {
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .app__phone {
    background-color: white;
    height: 620px;
    width: 375px;
    overflow: hidden;
  }

  .phone-header {
    height: 50px;
    width: 375px;
    position: sticky;
    position: -webkit-sticky;
    top: 0;
    background: #fafafa;
    border-bottom: 1px solid #eeeeee;
    z-index: 99;
  }

  img {
    max-width: 100px;
    display: block;
    margin: 0 auto;
    padding-top: 10px;
  }

  .cancel-cta,
  .next-cta {
    position: absolute;
    top: 12px;
    color: #209cee;
    font-weight: bold;
    cursor: pointer;
  }

  .cancel-cta {
    left: 10px;
  }

  .next-cta {
    right: 10px;
  }


  .feed {
    height: 100%;
    overflow-y: scroll;
    overflow-x: hidden;
    margin-right: -15px;
  }

  .instagram-post {
    padding-top: 50px;
  }

  .instagram-post ~ .instagram-post {
    padding-top: 0;
  }

  .instagram-post {
    padding: 5px 0;
  }
  .header {
    height: 30px;
    border-bottom: 1px solid #fff;
    margin: 7.5px 10px;
  }
  .image {
    display: inline-block;
  }
  img {
    border-radius: 99px;
  }
  .username {
    padding-left: 5px;
    font-size: 0.90rem;
    font-weight: bold;
  }

  .image-container {
    height: 330px;
    background-repeat: no-repeat;
    background-position: center center;
    background-size: cover;
  }
  .content {
    margin: 7.5px 10px;
  }
  .far.fa-heart,
  .fas.fa-heart{
    cursor: pointer;
  }
  .fas.fa-heart {
    color: #f06595;
  }
  .likes {
    margin: 5px 0;
    margin-bottom: 5px !important;
    font-size: 0.85rem;
    font-weight: bold;
  }
  .caption {
    font-size: 0.85rem;
  }
  span {
    font-weight: bold;
  }


  .instagram-post:last-child {
    margin-bottom: 80px;
  }

  .selected-image {
    background-repeat: no-repeat;
    background-size: cover;
    background-position: center center;
    height: 330px;
  }

  .filter-container {
    height: 210px;
    padding: 30px 10px;
    white-space: nowrap;
    overflow-x: hidden;
  }

  .filter-type {
    width: 100px;
    display: inline-block;
    margin: 0 3px;
  }
  p {
    font-size: 11px;
    text-align: center;
    text-transform: capitalize;
    padding-bottom: 5px;
  }
  .img {
    cursor: pointer;
    width: 100px;
    height: 100px;
    background-size: cover;
    background-position: center center;
  }

  .filter-type:last-child {
    margin-right: 20px;
  }

  .caption-container {
    height: 210px;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  textarea {
    border: 0;
    font-size: 1.0rem;
    width: 100%;
    padding: 10px;
    border-bottom: 1px solid #eeeeee;
  }

  textarea:focus {
    outline: 0;
  }

  .phone-footer {
    height: 35px;
    width: 375px;
    position: sticky;
    position: -webkit-sticky;
    bottom: 0;
    background: #fafafa;
    border-top: 1px solid #eeeeee;
    z-index: 99;
  }

  .home-cta {
    position: absolute;
    left: 10px;
    top: 6px;
    cursor: pointer;
  }

  .upload-cta {
    position: absolute;
    right: 10px;
    top: 6px;
  }
  p {
    font-size: 0.63rem;
    position: absolute;
    left: -25px;
    top: 5px;
  }

  input[name="file"] {
    visibility: hidden;
  }

  label {
    cursor: pointer;
    z-index: 99;
  }

  .details {
    position: absolute;
    left: 10px;
    bottom: 10px;
  }
  li {
    font-size: 0.8rem;
  }
  span {
    font-weight: bold;
  }

  .twitter-section {
    position: absolute;
    right: 10px;
    bottom: 10px;
  }
  .fa-twitter {
    color: #209cee;
    font-size: 2.0rem;
  }
  /*&:hover {*/
  /*   color: #1496ed;*/
  /* }*

  .fade-leave-active {
    transition: opacity .5s
  }
  .fade-leave-to {
    opacity: 0
  }

  // Media Queries
  @media(max-width: $small) {
    #app {
      height: 100% !important;
      padding-top: 0 !important;
    }

    .app__phone,
    .app__phone__scroll__cover {
      height: 100%;
      width: 100%;
    }

    .phone-header,
    .phone-footer {
      width: 100%;
    }
  }

  @media(max-width: $small) {
    .details {
      display: none;
    }
  }

  @media(max-width: $large) and (max-height: $medium) {
    #app {
      height: initial;
      padding-top: 5px;
    }
  }

</style>
