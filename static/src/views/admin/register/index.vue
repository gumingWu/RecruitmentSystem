<template>
    <el-card class="register-card" shadow="hover">
        <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="姓名">
                <el-input v-model="form.name" placeholder="请输入姓名" ></el-input>
            </el-form-item>
            <el-form-item label="手机号">
                <el-input v-model="form.telephone" placeholder="请输入手机号" ></el-input>
            </el-form-item>
            <el-form-item label="邮箱">
                <el-input v-model="form.email" placeholder="请输入邮箱" ></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="form.password" placeholder="请输入密码" ></el-input>
            </el-form-item>
            <el-form-item label="再次密码">
                <el-input v-model="form.sec_password" placeholder="请输入密码" ></el-input>
            </el-form-item>
            <el-form-item style="text-align: center" label-width="0">
                <el-button type="primary" style="width:45%" @click="handleRegister">确认</el-button>
                <el-button style="width:45%">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
import {register} from '@/api/admin'
export default {
    data () {
        return{
            form:{
                username:'',
                telephone:'',
                email:'',
                password:'',
                sec_password:'',
            }
        }
    },
    methods: {
        async handleRegister(){
            let data = {
                'username': this.form.name,
                'telephone': this.form.telephone,
                'email': this.form.email,
                'password': this.form.password
            }
            const res = await register(data)
            console.log(res)
        }
    }
}
</script>

<style>
.register-card{
    position:absolute;
    border-top: 10px solid #409EFF;
    left:0;
    right:0;
    width: 500px;
    margin:190px auto;
}
</style>