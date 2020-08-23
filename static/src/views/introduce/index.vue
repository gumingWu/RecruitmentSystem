<template>
    <el-container>
        <el-header style="padding:0">
            <el-row>
              <el-col :span="3">
                  <el-image :src="require('../../assets/images/applelogo.jpg')"></el-image>
              </el-col>
              <el-col :span="18">
                  <el-menu mode="horizontal" background-color="#191819" text-color="#fff" active-text-color="#ffd04b">
                    <el-menu-item index="1">公司介绍</el-menu-item>
                    <el-menu-item index="2">校园招聘</el-menu-item>
                </el-menu>
              </el-col>
              <el-col :span="3">
                  <div>
                      <el-image :src="require('../../assets/images/touxiang.png')"></el-image>
                  </div>
              </el-col>
            </el-row>
        </el-header>
        <el-main style="padding:0px">
            <el-image :src="require('../../assets/images/introduce001.jpg')" fit="fill"></el-image>
        </el-main>
    </el-container>
</template>

<script>
export default {
    
}
</script>

<style>

</style>