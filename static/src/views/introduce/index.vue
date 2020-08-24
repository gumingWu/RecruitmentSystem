<template>
    <el-container>
        <el-header style="padding:0">
            <el-row>
              <el-col :span="3" style="text-align:center">
                  <el-image :src="require('../../assets/images/social_wechat.png')" style="width:61px" @click="clickToHome"></el-image>
              </el-col>
              <el-col :span="18">
                  <el-menu mode="horizontal" background-color="#191819" text-color="#fff" active-text-color="#ffd04b">
                    <el-menu-item index="1" @click="clickToCompany">公司介绍</el-menu-item>
                    <el-menu-item index="2" @click="clickToSchool">校园招聘</el-menu-item>
                </el-menu>
              </el-col>
              <el-col :span="3" style="text-align: center">
                  <div>
                      <el-image :src="require('../../assets/images/touxiang.png')" style="width:61px"></el-image>
                  </div>
              </el-col>
            </el-row>
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
    }
}
</script>

<style>

</style>