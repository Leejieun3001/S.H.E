<template>
    <div class="container">
        <div class="scroll">
            <div class="content1">
                <a class href="./">
                    <div class="title">
                        <img src="src\assets\logo.png" alt="so._.mini logo" width="10px" height="10px"/>
                        <div class="column"></div>
                        <div class="logo">
                            <h6>so._.mini</h6>
                        </div>
                    </div>
                </a>
            </div>
            <div class="content2">
                <div>
                    <sui-search
                    placeholder="Search animal..."
                    :source="source"
                    v-model="valueBasic"
                    />
                    <sui-message :content="message" />
                    <sui-search
                    input
                    placeholder="Search animal..."
                    :source="source"
                    v-model="valueSelectIcon"
                    >
                    <i slot="icon" class="search icon"></i>
                    </sui-search>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "header",
        data() {
            return {
            valueBasic: null,
            valueSelectIcon: null,
            source: [
                { name: 'Horse' },
                { name: 'Parrot' },
                { name: 'Cat' },
                { name: 'Catfish' },
            ],
            message:
                'Using a ui input allows you to use additional input types, like this icon input',
            };
        },
    };
</script>

<style scoped>
    .container {
        position: fixed; 
        border-bottom: 1px solid rgba(var(--b6a,219,219,219),1);
        width: 100%; 
        height: 77px;
        top: 0;
        background: #ffffff;
        transition: top 0.2s ease-in-out;
        align-items: center;
    }

    .scroll {
        align-items: center;
        display: flex;
        flex-direction: row;
        height: 77px;
        -webkit-box-orient: horizontal;
        -webkit-box-direction: normal;
        -webkit-box-pack: center;
        justify-content: center;
        max-width: 975px;
        padding: 26px 20px;
        width: 100%;
        transition: top 0.2s ease-in-out;
    }

    .content1 {
        -webkit-box-flex: 1;
        flex: 1 9999 0%;
        min-width: 40px;
    }

    .content1 {
        -webkit-box-flex: 0;
        height: 28px;
        flex: 0 1 auto;
        min-width: 125px;
        width: 215px;
    }

    a, a:visited {
        color: rgba(var(--fe0,0,53,105),1);
        text-decoration: none;
    }

    .title {
        -webkit-box-flex: 0;
        -webkit-box-pack: start;
        -webkit-box-orient: horizontal;
        -webkit-box-direction: normal;
        flex: 0 0 auto;
        justify-content: flex-start;
        flex-direction: row;
        -webkit-box-align: center;
        align-items: center;
        align-content: stretch;
    }

    h6 {
        color:darkorchid;
        font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif
    }

    .column {
        background-color: rgba(var(--i1d,38,38,38),1);
        height: 28px;
        margin: 0 16px;
        transition: opacity .1s ease-out;
        width: 1px;
    }

    .logo {
        margin-top: 7px;
        transition: opacity .1s ease-out;
    }

    .search {
        -webkit-appearance: none;
        background: rgba(var(--b3f,250,250,250),1);
        border: solid 1px rgba(var(--b6a,219,219,219),1);
        border-radius: 3px;
        color: rgba(var(--i1d,38,38,38),1);
        outline: 0;
        padding: 3px 10px 3px 26px;
        z-index: 2;
        box-sizing: border-box;
        height: 100%;
        width: 100%;
    }
</style>

