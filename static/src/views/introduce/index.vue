<template>
    <el-container>
        <el-header style="padding:0">
            <div class="navbar">
                <div style="float:left; padding:13px; margin-left:50px" @click="clickToHome">
                    <el-image
                    style="width: 40px; height: 40px"
                    :src="require('../../assets/logo.png')"
                    fit="fit">
                    </el-image>
                </div>
                <el-menu mode="horizontal" background-color="#191819" text-color="#fff" active-text-color="#ffd04b" style="float:left">
                    <el-menu-item index="1" @click="clickToCompany">第一选项</el-menu-item>
                    <el-menu-item index="2" @click="clickToSchool">第二选项</el-menu-item>
                </el-menu>
                <div style="float:right; padding:16px; color:white; margin-right:50px; cursor: pointer;" @click="clickToLogin">
                    登录
                </div>
            </div>
        </el-header>
        <el-main style="padding:0px; border:1px solid black">
            <router-view></router-view>
        </el-main>
    </el-container>
</template>

<script>
export default {
    data () {
        return {
            
        }
    },
    methods: {
        clickToHome:function(){
            this.$router.push({name:'introhome'})
        },
        clickToCompany: function() {
            this.$router.push({name:'company'})
        },
        clickToSchool: function() {
            this.$router.push({name:'school'})
        },
        clickToLogin: function() {
            this.$router.push('/login')
        },
    }
}
</script>

<style>
.navbar{
    height: 60px;
    box-sizing: border-box;
    position: relative;
    width: 100%;
    font-size: 22px;
    background: #191819;
}
</style>