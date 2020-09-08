<template>
    <el-card class="register-card" shadow="hover">
        <el-form ref="form" :model="form" :rules="formRules" label-width="80px">
            <el-form-item label="姓名" prop="username">
                <el-input v-model="form.username" placeholder="请输入姓名" ></el-input>
            </el-form-item>
            <el-form-item label="手机号" prop="telephone">
                <el-input v-model="form.telephone" placeholder="请输入手机号" type="number"></el-input>
            </el-form-item>
            <el-form-item label="邮箱" prop="email">
                <el-input v-model="form.email" placeholder="请输入邮箱" ></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input v-model="form.password" placeholder="请输入密码" ></el-input>
            </el-form-item>
            <el-form-item label="再次密码" prop="sec_password">
                <el-input v-model="form.sec_password" placeholder="请输入密码" ></el-input>
            </el-form-item>
            <el-form-item style="text-align: center" label-width="0">
                <el-button type="primary" style="width:45%" @click="handleRegister">确认</el-button>
                <el-button style="width:45%" @click="handleResetForm('form')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
import {register} from '@/api/admin'
export default {
    data () {
        let validPhone = (rule, value, callback) => {
            let valid = /^1[3|4|5|7|8][0-9]\d{8}$/
            if(!valid.test(value)){
                callback(new Error('请输入正确格式手机号码'))
            } else{
                callback()
            }
        };
        let validPwd = (rule, value, callback) => {
            if(value===''){
                callback(new Error('请输入密码'))
            } else {
                if(this.form.sec_password!==''){
                    this.$refs['form'].validateField('sec_password')
                }
                callback()
            }
        };
        let validSecPwd = (rule, value, callback) => {
            if(value===''){
                callback(new Error("请再次输入密码"))
            } else {
                if(value!==this.form.password){
                    callback(new Error("与第一次输入的不相同"))
                }
            }
        };

        return{
            form:{
                username:'',
                telephone:'',
                email:'',
                password:'',
                sec_password:'',
            },

            formRules:{
                username:[
                    {required: true, message:'不能为空'}
                ],
                telephone:[
                    {required: true, message:'不能为空'},
                    {validator: validPhone, trigger: 'blur'}
                ],
                email:[
                    {required: true, message:'不能为空'},
                    {type: 'email', message:'邮件格式不规范'}
                ],
                password:[
                    {validator: validPwd, trigger: 'blur'}
                ],
                sec_password:[
                    {validator: validSecPwd, trigger: 'blur'}
                ]
            }
        }
    },
    methods: {
        async handleRegister(){
            let data = {
                'username': this.form.username,
                'telephone': this.form.telephone,
                'email': this.form.email,
                'password': this.form.password
            }
            // const res = await register(data)
            // console.log(res)
            await register(data).then((res) =>{
                console.log(res)
            })
            }
        },

        handleResetForm(formname) {
            this.$refs[formname].resetFields()
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